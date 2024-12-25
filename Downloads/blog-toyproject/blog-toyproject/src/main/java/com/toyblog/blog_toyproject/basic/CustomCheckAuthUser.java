package com.toyblog.blog_toyproject.basic;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

@Component
public class CustomCheckAuthUser {

	@Autowired
	private BlogMainMapper blogMainMapper;
	
	public boolean checkBoardWriter(Authentication authentication, Integer board_id) {
		
		Board board = blogMainMapper.selectPostBoardId(board_id);
		
		String username = authentication.getName();
		String writer = board.getWriter();
				
		return username.equals(writer);
	}
}
