package com.toyblog.blog_toyproject.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
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
	public String boardListPage(Model model) {
		
		List<Board> board = blogMainService.getBoardId();
		
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
}
