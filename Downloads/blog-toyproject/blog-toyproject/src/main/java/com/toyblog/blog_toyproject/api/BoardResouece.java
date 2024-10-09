package com.toyblog.blog_toyproject.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class BoardResouece {

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/about/{member_id}/post/{board_id}")
	public List<About> retrieveAboutPost(@PathVariable String member_id,
										@PathVariable Integer board_id) {
		
		return blogService.viewAboutPost(member_id, board_id);
	}
	
	@PostMapping("/about/{member_id}/post")
	@PreAuthorize("hasAuthority('admin')")
	public About writeAboutBody(@PathVariable String member_id,
				@RequestBody About about) {
		
		About writeAboutPost = blogService.addAbout(about.getWriter(), about.getAbout_id(),
					about.getBody(), member_id, about.getTitle(),
					about.getAbout_date());
		
		about.setBody(member_id);
		about.setMember_id(member_id);
		about.setWriter(member_id);
		
		return writeAboutPost;
	}
}
