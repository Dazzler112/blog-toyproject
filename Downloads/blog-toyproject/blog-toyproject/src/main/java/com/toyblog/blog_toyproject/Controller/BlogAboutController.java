package com.toyblog.blog_toyproject.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@Controller
public class BlogAboutController {
	
	@Autowired
	private BlogAboutService blogAboutService;
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	@GetMapping("about")
	public String aboutPage(Model model) {
		
		List<AboutImg> result = blogAboutService.getAboutImg();
		if(!result.isEmpty()) {
			model.addAttribute("aboutImg",result.get(0));
		}
		return "about/about";
	}
	
	@GetMapping("about/post")
	public String aboutBodyInputPage(Authentication authentication, Model model) {
		
	    // 인증 정보가 없을 경우 null 체크
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }	
		
		return "about/post";
	}
	
	@GetMapping("/about/post/-1")
	public String aboutBodyUpdatePage(Authentication authentication, Model model) {
		
	    // 인증 정보가 없을 경우 null 체크
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }	
		
		return "about/update";
	}
	
	@GetMapping("/about/img")
	public String aboutImgPost(Authentication authentication, Model model) {
		
	    // 인증 정보가 없을 경우 null 체크
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }		
		
		return "about/postimg";
	}
	
	@GetMapping("/about/updateimg/{aphoto_id}")
	public String updateImgPost(Authentication authentication, Model model) {
		
	    // 인증 정보가 없을 경우 null 체크
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }
		
		return "about/updateimg";
	}
}
