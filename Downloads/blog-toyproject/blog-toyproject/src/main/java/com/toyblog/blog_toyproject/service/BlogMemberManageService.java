package com.toyblog.blog_toyproject.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.mapper.*;

@Service
public class BlogMemberManageService {

	@Autowired
	private BlogMemberManageMapper blogMemberManageMapper;
}
