package com.toyblog.blog_toyproject.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@Controller
public class MemberController {
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	@GetMapping("/0")
	public String signUpPage() {
		return "members/signup";
	}
	
	@GetMapping("/1")
	@PreAuthorize("isAnonymous()")
	public String logInPage() {
		return "members/login";
	}
	
	
	@GetMapping("/2")
	@PreAuthorize("isAuthenticated() and (authentication.name eq #member_id)")
	public String modifyPage(String member_id, Model model) {
		
		Members member = blogMemberService.getMemberId(member_id);
		if (member == null) {
		    throw new RuntimeException("Member not found with member_id: " + member_id);
		}
		
		model.addAttribute("member", member);
		
		return "members/modify";
	}
	
	@GetMapping("/3")
	@PreAuthorize("isAuthenticated() and (authentication.name eq #member_id)")
	public String deletePage(String member_id, Model model) {

		Members member = blogMemberService.getMemberId(member_id);
		
		MemberAuthority memberAut = blogMemberService.getAuthorityId(member_id);
				
		model.addAttribute("member", member);
		model.addAttribute("memberAuth",memberAut);
		
		return "members/delete";
	}
}
