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
public class MemberManageController {
	
	@Autowired
	private BlogMemberService blogMemberService;

	@GetMapping("/manage")
	public String MemberManage(Authentication authentication, Model model) {
		
		
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }	
		
		if(authentication == null || authentication.getName() == null) {
			return "members/login";
		}else {
		List<Members> member = blogMemberService.getMemberListInfo();
		model.addAttribute("memberList", member);
		}
		return "manage/manage";
	}
}
