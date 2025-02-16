package com.toyblog.blog_toyproject.api;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class AboutResouece {

	@Autowired
	private BlogAboutService blogAboutService;
	
	public AboutResouece(BlogAboutService blogAboutService) {
		this.blogAboutService = blogAboutService;
	}
	
	@GetMapping("/about/post/{about_id}")
	public About retrieveAboutPost(@PathVariable Integer about_id) {
//		System.out.println("test");
		About list = blogAboutService.viewAboutPost(about_id);
		
		return list;
	}
	
	@PostMapping("/about/{member_id}/post")
	@PreAuthorize("hasAuthority('admin')")
	public About writeAboutBody(@PathVariable String member_id,
				@RequestBody About about) {
		
		
		About writeAboutPost = blogAboutService.addAbout(about.getAbout_id(),
					about.getBody(), member_id);
		
		about.setBody(member_id);
		about.setMember_id(member_id);
		
		return writeAboutPost;
	}
	
	//삭제를 사용하지 않고 삭제 서비스를 수정 서비스에서 호출후 넣는 방식으로
	@DeleteMapping("/about/{member_id}/post/{about_id}")
	public ResponseEntity<Void> deleteAboutBody(@PathVariable String member_id,
									@PathVariable Integer about_id){
		blogAboutService.deleteByAboutId(about_id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/about/{member_id}/post/{about_id}")
	@PreAuthorize("hasAuthority('admin')")
	public About updateAboutBody(@PathVariable String member_id,
							@PathVariable Integer about_id, @RequestBody About about) {
		
		System.out.println("test");
		blogAboutService.updateAbout(about);
		about.getAbout_id();
		about.getMember_id();
		
		return about;
	}
		
	@PostMapping(value = "/about/imgpost", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Map<String, Object>> postImgCreate(
									@RequestParam(value = "aphotoFile", required = false) MultipartFile[] files,
									Authentication authentication) throws IOException {
		
		AboutImg aboutImg = new AboutImg();
		aboutImg.setMember_id(authentication.getName());
		
		Map<String, Object> addImg = blogAboutService.newPostImg(aboutImg, files);
		
		Map<String, Object> result = new HashMap<>();
		if(addImg != null && !addImg.isEmpty()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
		}
	}
	
	@GetMapping("/about/imgpost/{aphoto_id}")
	public ResponseEntity<Map<String, Object>>getImginfo(@PathVariable Integer aphoto_id) {
		
		AboutImg aboutImg = blogAboutService.getImgBoardInfo(aphoto_id);
		
		
	    if (aboutImg == null) {
	        System.out.println("DB에서 aphoto_id " + aphoto_id + " 의 데이터를 찾을 수 없음."); // 🔥 디버깅 로그
	    } else {
	        System.out.println("가져온 데이터: " + aboutImg); // 🔥 디버깅 로그
	    }
		
		Map<String, Object> result = new HashMap<>();
		
		if(aboutImg != null) {
	        result.put("aphoto_id", aboutImg.getAphoto_id());
	        result.put("member_id", aboutImg.getMember_id());
	        result.put("photo_name", aboutImg.getPhoto_name());
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
		}
	}
	
	@PostMapping(value="/about/imgpost/{aphoto_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Map<String, Object>>aboutImgModify(@PathVariable Integer aphoto_id,
															 @RequestParam(value="deleteAboutPhoto", required = false) List<String> removeFiles,
															 @RequestParam(value = "AboutPhoto",required = false) MultipartFile[] addFile,
															 Authentication authentication) throws IOException {
		AboutImg aboutImg = new AboutImg();
		aboutImg.setAphoto_id(aphoto_id);
		aboutImg.setMember_id(authentication.getName());
		
		Map<String, Object> img = blogAboutService.modifyImg(aboutImg, removeFiles, addFile);
		System.out.println("🚀 modifyImg 결과: " + img);
		if(img != null && !img.isEmpty()) {
			System.out.println("success" + img);
			return ResponseEntity.ok(img);
		} else {
			System.out.println("fail" + img);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(img);
		}
	}
	
}
