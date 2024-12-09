package com.toyblog.blog_toyproject.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;

@Slf4j
@RestController
public class MemberResource {
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	public MemberResource(BlogMemberService blogMemberService) {
		this.blogMemberService = blogMemberService;
	}
	
	//회원 가입
	@PostMapping("/members/signup")
	public ResponseEntity<?> signUpMember(@RequestBody Members member, 
				HttpSession session) {
		
		boolean signUpMember = blogMemberService.addMembers(member);
		
		session.setAttribute("signUpMessage", "회원 생성이 완료되었습니다. 로그인 해주세요");
		
		return ResponseEntity.status(HttpStatus.OK).body("/1");
		
	}
	
	//id validation
	@GetMapping("/members/checkid/{member_id}")
	public Map<String, Object> checkMemberId(@PathVariable String member_id) {
		
		return blogMemberService.checkId(member_id);
	}
	
	//phone validation
	@GetMapping("/members/checkphone/{phone_number}")
	public Map<String, Object> checkPhoneNumber(@PathVariable String phone_number
										, Authentication authentication) {
		
		return blogMemberService.CheckPhoneNum(phone_number, authentication);
	}
	
	
	@PostMapping("/members/modify")
	public void modifyMemberId(@RequestBody Members member, Authentication authentication) {
		
		boolean modifyId = blogMemberService.modifyMemberId(member, authentication);

//		log.info("modifyId: {}", modifyId);
	}
	
	@PostMapping("/members/remove")
	public ResponseEntity<Void> deleteMember(@RequestBody Members member, Authentication authentication, RedirectAttributes rttr) {
		
		boolean memberDelete = blogMemberService.removeMemberId(member, authentication);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/members/findid")
	public String findId(@RequestBody Members member, String email) {

		System.err.println("Controller => " + member.getEmail());
		String result = blogMemberService.findMemberId(member);
		
		return result;
	}
	
	@PostMapping("/members/findpw")
	public void findPassword(@RequestBody Members member, Authentication authentication) {
		
		boolean findPwMember = blogMemberService.findMemberPassword(member, authentication);
	}

}
