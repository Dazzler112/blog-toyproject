package com.toyblog.blog_toyproject.service;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

@Service
public class BlogAboutService {

	@Autowired
	private BlogAboutMapper blogAboutMapper;
	
	private static List<About> aboutit = new ArrayList<>();

	public BlogAboutService(BlogAboutMapper blogAboutMapper) {
		this.blogAboutMapper = blogAboutMapper;
	}
	
	public About findByMemberId(String member_id) {
		
		return blogAboutMapper.findByMemberId(member_id);
	}
	
//	public About viewAboutPost(Integer about_id) {
//		
//		return blogAboutMapper.findByAboutId(about_id);		
//	}
	
	public List<About> viewAboutPost(Integer about_id) {
		
		List<About> list = blogAboutMapper.findByAboutId(about_id);
		
		return list;
	}
	
	
	public About addAbout(String writer, Integer about_id, String body, String member_id, String title,
			LocalDate about_date) {

		
		About about = new About(about_id, title, member_id, writer, body, about_date);
		blogAboutMapper.addAboutBody(about);
		aboutit.add(about);
		
		return about;
	}

	public void updateAbout(About about) {
		
		// 업데이트 수정중 삭제로직인데 추후 사이트 만들어보고 확인
//		blogAboutMapper.deleteAboutBody(about.getAbout_id());
		
		blogAboutMapper.insertAboutBody(about.getAbout_id());
		
		aboutit.add(about);
	}

}
