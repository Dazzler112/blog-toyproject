package com.toyblog.blog_toyproject.api;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class BoardResouece {

	@Autowired
	private BlogService blogService;
	
	@PostMapping("/about/{writer}/post")
	public About writeAboutBody(@PathVariable String writer,
				@RequestBody About about) {
		
		About writeAboutPost = blogService.addAbout(writer, about.getAbout_id(),
					about.getBody(), about.getMember_id(), about.getTitle(),
					about.getAbout_date());
		
		about.setBody(writer);
		about.setMember_id(writer);
		about.setWriter(writer);
		
		return writeAboutPost;
	}
}
