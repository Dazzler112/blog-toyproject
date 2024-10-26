package com.toyblog.blog_toyproject.api;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.ui.*;
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

// 나중에 Board의 Post에 사용		
//	@GetMapping("/about/{member_id}/post")
//	public ResponseEntity<About> retrieveAboutPosts(@PathVariable String member_id) {
//
//		About about = blogAboutService.findByMemberId(member_id);
//		
//		if(about != null) {
//			return ResponseEntity.ok(about);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	@GetMapping("/about/{member_id}/post/{about_id}")
	public About retrieveAboutPost(@PathVariable String member_id,
									@PathVariable Integer about_id, Model model) {
//		System.out.println("test");
		About list = blogAboutService.viewAboutPost(about_id);
		
		return list;
	}
	
	@PostMapping("/about/{member_id}/post")
	@PreAuthorize("hasAuthority('admin')")
	public About writeAboutBody(@PathVariable String member_id,
				@RequestBody About about) {
		
		System.out.println("test");
		
		About writeAboutPost = blogAboutService.addAbout(about.getAbout_id(),
					about.getBody(), member_id);
		
		about.setBody(member_id);
		about.setMember_id(member_id);
		
		return writeAboutPost;
	}
	
	@PutMapping("/about/{member_id}/post/{about_id}")
	public About updateAboutBody(@PathVariable String member_id,
							@PathVariable Integer about_id, @RequestBody About about) {
		
		blogAboutService.updateAbout(about);
		return about;
	}
	
}
