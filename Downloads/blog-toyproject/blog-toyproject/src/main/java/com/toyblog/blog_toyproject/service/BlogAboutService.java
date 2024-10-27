package com.toyblog.blog_toyproject.service;

import java.util.*;
import java.util.function.*;

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
	
// 나중에 Board의 Post에 사용	
//	public About findByMemberId(String member_id) {
//		
//		return blogAboutMapper.findByMemberId(member_id);
//	}
	
	
	public About viewAboutPost(Integer about_id) {
		
		About list = blogAboutMapper.findByAboutId(about_id);
		
		return list;
	}
	
	
	public About addAbout(Integer about_id, String body, String member_id) {
		About about = new About(about_id, member_id, body);
		blogAboutMapper.addAboutBody(about);
		aboutit.add(about);
		
		return about;
	}

	public void deleteByAboutId(Integer about_id) {
		// TODO Auto-generated method stub
		blogAboutMapper.deleteAboutBody(about_id);
		Predicate<? super About> predicate = about -> about.getAbout_id() == about_id; 
		aboutit.removeIf(predicate);
	}
	
	public void updateAbout(About about) {
		
		// 업데이트 수정중 삭제로직인데 추후 사이트 만들어보고 확인
//		blogAboutMapper.deleteAboutBody(about.getAbout_id());
//		deleteByAboutId(about.getAbout_id());
		blogAboutMapper.insertAboutBody(about);

		aboutit.add(about);
	}

}
