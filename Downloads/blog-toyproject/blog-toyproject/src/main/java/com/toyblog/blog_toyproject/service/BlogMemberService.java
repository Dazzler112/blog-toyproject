package com.toyblog.blog_toyproject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

@Service
public class BlogMemberService {

	@Autowired
	private BlogMemberMapper blogMemberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public BlogMemberService(BlogMemberMapper blogMemberMapper) {
		this.blogMemberMapper = blogMemberMapper;
	}

	public boolean addMembers(Members member) {
		
		String encryption = member.getPassword();
		String encryptedPassword = passwordEncoder.encode(encryption);
		member.setPassword(encryptedPassword);
		
		int cnt = blogMemberMapper.SignUp(member);
		blogMemberMapper.insertAuthority(member);
		System.out.println("문제가 발생");
		return cnt ==1;
	}

	public Map<String, Object> checkId(String member_id) {

		Members member = blogMemberMapper.selectByMemberId(member_id);
		
//		boolean available = (member == null);
		return Map.of("available", member == null);
	}

	public Map<String, Object> CheckPhoneNum(String phone_number, Authentication authentication) {
		
		Members member = blogMemberMapper.selectByPhoneNumber(phone_number);
		
		if(authentication != null) {
			Members ordinaryMember = blogMemberMapper.selectByMemberId(authentication.getName());
			
			return Map.of("available", member == null || ordinaryMember.getPhone_number().equals(phone_number));
		} else {
			return Map.of("available", member == null);
		}
	}
	
}
