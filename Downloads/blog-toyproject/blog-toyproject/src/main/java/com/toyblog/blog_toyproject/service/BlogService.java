package com.toyblog.blog_toyproject.service;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

@Service
public class BlogService {

	@Autowired
	private BlogBoardMapper blogBoardMapper;
	
	private static List<About> aboutit = new ArrayList<>();

	public About addAbout(String writer, Integer about_id, String body, String member_id, String title,
			LocalDate about_date) {

		
		About about = new About(about_id, title, member_id, writer, body, about_date);
		int addAboutBody = blogBoardMapper.addAboutBody(about);
		aboutit.add(about);
		
		return about;
	}

	
	public List<About> viewAboutPost(String member_id, Integer board_id) {
		
		List<About> aboutList = blogBoardMapper.findByMembeId(member_id, board_id);	
		
		return aboutList;
	}
}
