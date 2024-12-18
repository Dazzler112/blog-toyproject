package com.toyblog.blog_toyproject.Controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogAboutController {
	
	
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
