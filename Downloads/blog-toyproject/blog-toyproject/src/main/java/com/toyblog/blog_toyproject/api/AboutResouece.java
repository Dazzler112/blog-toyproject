package com.toyblog.blog_toyproject.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class AboutResouece {

	@Autowired
	private BlogAboutService blogAboutService;
	
	public AboutResouece(BlogAboutService blogAboutService) {
		this.blogAboutService = blogAboutService;
	}
	
	@GetMapping("/about/{member_id}/post")
	public ResponseEntity<About> retrieveAboutPosts(@PathVariable String member_id) {

		About about = blogAboutService.findByMemberId(member_id);
		
		if(about != null) {
			return ResponseEntity.ok(about);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@GetMapping("/about/{member_id}/post/{about_id}")
//	public ResponseEntity<About> retrieveAboutPost(@PathVariable String member_id,
//									@PathVariable Integer about_id) {
//		
//		About about = blogAboutService.viewAboutPost(about_id);
//		
//		if(about != null) {
//			return ResponseEntity.ok(about);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	@GetMapping("/about/{member_id}/post/{about_id}")
	public List<About> retrieveAboutPost(@PathVariable String member_id,
									@PathVariable Integer about_id) {
		
		List<About> list = blogAboutService.viewAboutPost(about_id);
		
		return list;
	}
	
	@PostMapping("/about/{member_id}/post")
	@PreAuthorize("hasAuthority('admin')")
	public About writeAboutBody(@PathVariable String member_id,
				@RequestBody About about) {
		
		About writeAboutPost = blogAboutService.addAbout(about.getWriter(), about.getAbout_id(),
					about.getBody(), member_id, about.getTitle(),
					about.getAbout_date());
		
		about.setBody(member_id);
		about.setMember_id(member_id);
		about.setWriter(member_id);
		
		return writeAboutPost;
	}
}
