package com.toyblog.blog_toyproject.service;

import java.io.*;
import java.util.*;
import java.util.function.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

import software.amazon.awssdk.core.sync.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

@Service
public class BlogAboutService {

	@Autowired
	private S3Client s3;
	
	@Value("${aws.s3.bucketName}")
	private String bucketName;	
	
	@Autowired
	private BlogAboutMapper blogAboutMapper;
	
	private static List<About> aboutit = new ArrayList<>();

	public BlogAboutService(BlogAboutMapper blogAboutMapper) {
		this.blogAboutMapper = blogAboutMapper;
	}
	

	
	public About viewAboutPost(Integer about_id) {
		
		About list = blogAboutMapper.findByAboutId(about_id);
		
		return list;
	}
	
	
	public About addAbout(Integer about_id, String body, String member_id) {
		About about = new About(about_id, member_id, body);
		blogAboutMapper.addAboutBody(about);
		aboutit.add(about);
		
		return about;
	}

	//해당 로직 무 쓸모 그냥 삭제만 실행되고 update에 넣었을 때 update는 진행이 안됨
	public void deleteByAboutId(Integer about_id) {
		// TODO Auto-generated method stub
		blogAboutMapper.deleteAboutBody(about_id);
		Predicate<? super About> predicate = about -> about.getAbout_id() == about_id; 
		aboutit.removeIf(predicate);
	}
	
	public void updateAbout(About about) {
		
//		deleteByAboutId(about.getAbout_id());   <= 이 로직이 있으니 수정으로 안가고 바로 삭제하고 끝남 (DB가 삭제가 됨)
		blogAboutMapper.insertAboutBody(about);

		aboutit.add(about);
	}

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> newPostImg(AboutImg aboutImg, MultipartFile[] files) throws IOException {
		Map<String, Object> result = new HashMap<>();
		
		int cnt = blogAboutMapper.insertPhoto(aboutImg);
		if(files != null && files.length > 0) {
			for(MultipartFile file : files) {
				if(file.getSize() > 0) {
					blogAboutMapper.insertFileName(aboutImg.getAphoto_id(), file.getOriginalFilename());
					String ObjectKey = "review_blog_project/" + "About" + "/" + aboutImg.getAphoto_id() + "/" + file.getOriginalFilename();
					
					PutObjectRequest putObjectRequest = PutObjectRequest.builder()
							.bucket(bucketName)
							.key(ObjectKey)
							.acl(ObjectCannedACL.PUBLIC_READ)
							.build();
					RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
					
					s3.putObject(putObjectRequest, requestBody);
				}
			}
		}
		result.put("aboutImg", cnt);
		
		return result;
	}

	public List<AboutImg> getAboutImg() {
		
		List<AboutImg> aboutImg = blogAboutMapper.getAboutImgPost();
		
		return aboutImg;
	}



	public Map<String, Object> modifyImg(AboutImg aboutImg, List<String> removeFiles, MultipartFile[] addFile) throws IOException {
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("🚀 수정 요청 시작: " + aboutImg);
		
		if(removeFiles != null && !removeFiles.isEmpty()) {
			for(String fileName : removeFiles) {
				System.out.println("❌ 삭제할 파일: " + fileName);
				
				String fileKey = "review_blog_project/" + "About" + "/" + aboutImg.getAphoto_id() + "/" + fileName;
				DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
						.bucket(bucketName)
						.key(fileKey)
						.build();
				
				s3.deleteObject(deleteObjectRequest);
				
				 System.out.println("📌 삭제 결과: " + deleteObjectRequest);
				
				blogAboutMapper.deleteAboutPhotoName(aboutImg.getAphoto_id(), fileName);
			}
		}
		
		if(addFile != null && addFile.length > 0) {
			for(MultipartFile file : addFile) {
				System.out.println("📂 추가할 파일: " + file.getOriginalFilename());
				
				blogAboutMapper.updateAboutPhotoName(aboutImg.getAphoto_id(), file.getOriginalFilename());
				
				String fileKey = "review_blog_project/" + "About" + "/" + aboutImg.getAphoto_id() + "/" + file.getOriginalFilename();
				PutObjectRequest putObjectRequest = PutObjectRequest.builder()
						.acl(ObjectCannedACL.PUBLIC_READ)
						.bucket(bucketName)
						.key(fileKey)
						.build();
				
				RequestBody request = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
				s3.putObject(putObjectRequest, request);
				
				System.out.println("📌 추가 결과: " + putObjectRequest);
			}
		}
		System.out.println("🚀 최종 결과: " + result);
		return result;
	}



	public AboutImg getImgBoardInfo(Integer aphoto_id) {
		
		AboutImg aboutImg = blogAboutMapper.selectImgInfo(aphoto_id);
		
		return aboutImg;
	}

}
