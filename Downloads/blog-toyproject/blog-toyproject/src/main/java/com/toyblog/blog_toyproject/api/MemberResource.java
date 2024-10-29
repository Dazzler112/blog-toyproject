package com.toyblog.blog_toyproject.api;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class MemberResource {
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	public MemberResource(BlogMemberService blogMemberService) {
		this.blogMemberService = blogMemberService;
	}
	
	@PostMapping("/members/signup")
	public void signUpMember(@RequestBody Members member) {
		
		boolean signUpMember = blogMemberService.addMembers(member);
		
		System.out.println("testController");
		
	}
}
