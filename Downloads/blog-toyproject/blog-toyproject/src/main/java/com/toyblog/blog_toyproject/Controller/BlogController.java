package com.toyblog.blog_toyproject.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.service.*;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("post")
	public String boardPage() {
		
		return "main/main-view";
	}
	
	@GetMapping("about")
	public String aboutPage() {
		
		return "about/about";
	}
	
	@GetMapping("about/post")
	public String aboutBodyInputPage() {
		
		return "about/post";
	}
	
	@GetMapping("/about/post/-1")
	public String aboutBodyUpdatePage() {
		
		return "about/update";
	}
}
