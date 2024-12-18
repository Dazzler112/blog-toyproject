package com.toyblog.blog_toyproject.Controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogMainController {

	@GetMapping("main")
	public String boardPage() {
		
		return "main/mainview";
	}
	
	@GetMapping("main/post")
	public String boardPostPage() {
		
		return "main/post";
	}
}
