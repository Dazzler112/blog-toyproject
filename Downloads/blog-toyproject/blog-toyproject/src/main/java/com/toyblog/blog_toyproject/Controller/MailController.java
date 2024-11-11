package com.toyblog.blog_toyproject.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.service.*;

@Controller
public class MailController {

	@Autowired
	private MailSendService mailSendService;
	

}
