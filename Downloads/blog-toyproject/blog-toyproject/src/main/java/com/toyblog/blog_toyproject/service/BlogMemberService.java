package com.toyblog.blog_toyproject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

import lombok.extern.slf4j.*;

@Slf4j
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
		return cnt ==1;
	}

	public Map<String, Object> checkId(String member_id) {

		Members member = blogMemberMapper.selectByMemberId(member_id);
		
//		boolean available = (member == null);
		return Map.of("available", member == null);
	}

	public Map<String, Object> CheckPhoneNum(String phone_number, Authentication authentication) {
		
		Members member = blogMemberMapper.selectByPhoneNumber(phone_number);
		
		if (authentication != null) {
		    Members ordinaryMember = blogMemberMapper.selectByMemberId(authentication.getName());
		    return Map.of("available", ordinaryMember == null || ordinaryMember.getPhone_number().equals(phone_number));
		}else {
		        return Map.of("available", member == null);
		}
	}


	public boolean modifyMemberId(Members member, Authentication authentication) {
		
//		System.err.println("service => " + member.getPassword());
		if(!member.getPassword().isBlank()) {
			
			String plain = member.getPassword();
			member.setPassword(passwordEncoder.encode(plain));
		}
		
		Members oldMember = blogMemberMapper.selectByMemberId(authentication.getName());
		
		
//		if (oldMember == null) {
//		    throw new RuntimeException("Member not found for ID: " + member.getMember_id());
//		}
//		System.err.println("oldMember service => " + oldMember.getMember_id()+" , " + oldMember.getPassword());

		int cnt = 0;
		cnt = blogMemberMapper.memberUpdate(member);

		return cnt == 1;
	}
	

	//회원정보 가져오기
	public Members getMember(String member_id) {
		
		return blogMemberMapper.selectByMemberId(member_id);
	}

	public Members getMemberId(String member_id) {
		
		return blogMemberMapper.selectByMemberId(member_id);
	}

	public boolean removeMemberId(Members member, Authentication authentication) {
		
		Members getMember = blogMemberMapper.selectByMemberId(authentication.getName());
		int cnt = 0;
		
		blogMemberMapper.deleteMemberAuthority(authentication.getName());
		cnt = blogMemberMapper.deleteMemberId(authentication.getName());
		log.info("deleteInfo: {}", cnt);
		
		System.out.println("members => " + member.getMember_id() + member.getPassword());
		return cnt == 1;
	}
	
}
