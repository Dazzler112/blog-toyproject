package com.toyblog.blog_toyproject.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.mapper.*;

@Service
public class BlogService {

	@Autowired
	private BlogBoardMapper blogBoardMapper;
}
