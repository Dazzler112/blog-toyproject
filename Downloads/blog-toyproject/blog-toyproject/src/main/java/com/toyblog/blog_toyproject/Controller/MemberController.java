package com.toyblog.blog_toyproject.Controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

	@GetMapping("/0")
	public String SignUpPage() {
		return "members/signup";
	}
}
