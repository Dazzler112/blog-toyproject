package com.toyblog.blog_toyproject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

@Service
public class BlogMemberManageService {

	@Autowired
	private BlogMemberManageMapper blogMemberManageMapper;

	public Map<String, Object> setUserBlock(Members members) {
		
		Map<String, Object> result = new HashMap<>();
		
		int cnt = blogMemberManageMapper.setUserBlock(members); 
		
		result.put("blockUser", cnt);
		
		return result;
	}

	public Map<String, Object> setUserRemove(Members member) {
		
		Map<String, Object> result = new HashMap<>();
		
		int cnt = blogMemberManageMapper.setUserRemove(member);
		
		result.put("removeUser", cnt);
		
		return result;
	}
}
