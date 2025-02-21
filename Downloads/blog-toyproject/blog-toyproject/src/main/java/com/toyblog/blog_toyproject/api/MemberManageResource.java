package com.toyblog.blog_toyproject.api;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.service.*;

@RestController
public class MemberManageResource {

	@Autowired
	private BlogMemberManageService blogMemberManageService;
	
	
}
