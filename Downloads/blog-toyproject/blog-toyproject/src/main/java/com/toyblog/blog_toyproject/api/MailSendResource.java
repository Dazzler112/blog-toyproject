package com.toyblog.blog_toyproject.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.service.*;

import jakarta.servlet.http.*;

@RestController
public class MailSendResource {

	@Autowired
	private MailSendService mailSendService;
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	@PostMapping("/mail/code")
	public void CheckEmailCode(String email, HttpSession http) {
		
		mailSendService.SendMail(email, http);
	}
	
	@PostMapping("/mailcheck")
	public Map<String, Object> mailCheck(Integer enteredCode, HttpSession http) {
		Boolean ok = mailSendService.compareNum(enteredCode, http);
		
		return Map.of("authentication", ok);
	}
	
	@PostMapping("/searchmail")
	public Map<String, Object> checkMailId(@RequestBody String email, Authentication authentication) {
		
		return blogMemberService.checkMailId(email, authentication);
	}

}
