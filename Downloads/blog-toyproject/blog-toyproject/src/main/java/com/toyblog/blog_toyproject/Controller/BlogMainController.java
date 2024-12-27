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
	
	@GetMapping("main")
	public String boardListPage(Model model,Authentication authentication) {
		
		List<Board> board = blogMainService.getBoardId(authentication);
		
		model.addAttribute("boardList",board);
		
		return "main/mainview";
	}
	
	@GetMapping("main/{board_id}")
	public String getBoardPage () {
		
		return "main/getpage";
	} 
	
	@GetMapping("main/post")
	public String boardPostPage() {
		
		return "main/post";
	}
	
	@GetMapping("main/remove")
	public String deletePost() {
		
		return "main/remove";
	}
	
	@GetMapping("main/modify/{board_id}")
	public String modifyPost() {
		
		return "main/modify";
	}
}
