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
public class BlogMainController {

	@Autowired
	private BlogMainService blogMainService; 
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	@GetMapping("main")
	public String boardListPage(@RequestParam(value = "search", defaultValue = "") String search,
								@RequestParam(value = "type", required = false) String type,
								Model model,
								Authentication authentication) {
		
//		List<Board> board = blogMainService.getBoardId(authentication);
//		model.addAttribute("boardList",board);
		Map<String, Object> result = blogMainService.resultListMain(authentication ,search, type);
		model.addAllAttributes(result);
		
		return "main/mainview";
	}
	
	@GetMapping("main/{board_id}")
	public String getBoardPage () {
		
		return "main/getpage";
	} 
	
	@GetMapping("main/post")
	public String boardPostPage(Authentication authentication, Model model) {
		
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }	
		
		return "main/post";
	}
	
	@GetMapping("main/remove")
	public String deletePost() {
		
		return "main/remove";
	}
	
	@GetMapping("main/modify/{board_id}")
	public String modifyPost(Authentication authentication, Model model) {
		
	    if (authentication == null || authentication.getName() == null) {
	        model.addAttribute("member", null); // 로그인 안 한 상태 전달
	    } else {
	        String member_id = authentication.getName();
	        Members member = blogMemberService.getMemberInfo(member_id);
	        model.addAttribute("member", member);
	    }	
		
		return "main/modify";
	}
}
