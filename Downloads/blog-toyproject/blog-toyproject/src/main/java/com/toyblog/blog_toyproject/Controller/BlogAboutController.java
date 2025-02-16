package com.toyblog.blog_toyproject.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@Controller
public class BlogAboutController {
	
	@Autowired
	private BlogAboutService blogAboutService;
	
	@GetMapping("about")
	public String aboutPage(Model model) {
		
		List<AboutImg> result = blogAboutService.getAboutImg();
		if(!result.isEmpty()) {
			model.addAttribute("aboutImg",result.get(0));
		}
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
	
	@GetMapping("/about/img")
	public String aboutImgPost() {
		
		return "about/postimg";
	}
	
	@GetMapping("/about/updateimg/{aphoto_id}")
	public String updateImgPost() {
		
		return "about/updateimg";
	}
}
