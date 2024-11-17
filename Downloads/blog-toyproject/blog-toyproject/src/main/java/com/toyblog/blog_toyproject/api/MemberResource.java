package com.toyblog.blog_toyproject.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

import jakarta.servlet.http.*;

@RestController
public class MemberResource {
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	public MemberResource(BlogMemberService blogMemberService) {
		this.blogMemberService = blogMemberService;
	}
	
	//회원 가입
	@PostMapping("/members/signup")
	public ResponseEntity<?> SignUpMember(@RequestBody Members member, 
				HttpSession session, HttpServletResponse response) {
		
		boolean signUpMember = blogMemberService.addMembers(member);
		
		session.setAttribute("signUpMessage", "회원 생성이 완료되었습니다. 로그인 해주세요");
		
		return ResponseEntity.status(HttpStatus.OK).body("/1");
		
	}
	
	//id validation
	@GetMapping("/members/checkid/{member_id}")
	public Map<String, Object> CheckMemberId(@PathVariable String member_id) {
		
		return blogMemberService.checkId(member_id);
	}
	
	//phone validation
	@GetMapping("/members/checkphone/{phone_number}")
	public Map<String, Object> CheckPhoneNumber(@PathVariable String phone_number
										, Authentication authentication) {
		
		return blogMemberService.CheckPhoneNum(phone_number, authentication);
	}
	
}
