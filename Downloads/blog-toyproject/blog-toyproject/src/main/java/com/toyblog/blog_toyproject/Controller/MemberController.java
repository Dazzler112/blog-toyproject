package com.toyblog.blog_toyproject.Controller;

import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@Controller
public class MemberController {

	private BlogMemberService blogMemberService;
	
	@GetMapping("/0")
	public String SignUpPage() {
		return "members/signup";
	}
	
	@GetMapping("/1")
	@PreAuthorize("isAnonymous()")
	public String LogInPage() {
		return "members/login";
	}
	
	
	@GetMapping("/2")
	@PreAuthorize("isAuthenticated() and (authentication.name eq #member_id)")
	public String ModifyPage(String member_id) {
//		Members member = blogMemberService.getMember(member_id);
//		
//		System.out.println("member Parse" + member);
		return "members/modify";
	}
	
	@GetMapping("/members/modify")
	public void ModifyGetMemberId(String member_id, Model model) {
		Members member = blogMemberService.getMemberId(member_id);
		
		model.addAttribute("member", member);
	}

}
