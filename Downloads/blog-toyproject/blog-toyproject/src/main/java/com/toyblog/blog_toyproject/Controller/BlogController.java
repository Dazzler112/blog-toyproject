package com.toyblog.blog_toyproject.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.service.*;

@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("post")
	public String boardPage() {
		
		return "main/main-view";
	}
}
