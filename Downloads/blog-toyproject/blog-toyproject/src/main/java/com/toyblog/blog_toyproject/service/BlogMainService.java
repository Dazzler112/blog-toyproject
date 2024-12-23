package com.toyblog.blog_toyproject.service;

import java.io.*;
import java.util.*;

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
public class BlogMainService {

	@Autowired
	private S3Client s3;
	
	@Value("${aws.s3.bucketName}")
	private String bucketName;
	
	@Autowired
	private BlogMainMapper blogMainMapper;

	@Transactional(rollbackFor = Exception.class)
	public boolean addboard(Board board, MultipartFile[] files) throws IOException {
		
		int cnt = blogMainMapper.insertBoard(board);
		for(MultipartFile file : files) {
			if(file.getSize() > 0) {
				blogMainMapper.insertFileName(board.getBoard_id(), file.getOriginalFilename());
				String ObjectKey = "review_blog_project/" + board.getBoard_id() + "/" + file.getOriginalFilename();
				
				PutObjectRequest putObjectRequest = PutObjectRequest.builder()
						.bucket(bucketName)
						.key(ObjectKey)
						.acl(ObjectCannedACL.PUBLIC_READ)
						.build();
				RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
				
				s3.putObject(putObjectRequest, requestBody);
			}
		}
		return cnt == 1;
	}

	public List<Board> getBoardId() {
		
		List<Board> board = blogMainMapper.selectBoard();
		
		return board;
	}

	public List<Board> getPostBoardId(Integer board_id) {
		
		List<Board> board = blogMainMapper.selectPostBoardId(board_id);
		
		return board;
	}
	
	public boolean removeMainPost(Integer board_id) {

		List<String> photoNames = blogMainMapper.selectPhotoFile(board_id);
		
		blogMainMapper.deletePhotoBoardId(board_id);
		
		for(String photoName : photoNames) {
			String photoKey = "review_blog_project" + board_id + "/" + photoName;
			DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
					.bucket(bucketName)
					.key(photoKey)
					.build();
			
				s3.deleteObject(deleteObjectRequest);
		}
		
		int cnt = blogMainMapper.deletePost(board_id);
		
		return cnt == 1;
	}	
}
