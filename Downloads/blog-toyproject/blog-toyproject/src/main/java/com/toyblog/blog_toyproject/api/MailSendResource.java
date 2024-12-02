package com.toyblog.blog_toyproject.api;

import java.io.*;
import java.net.*;
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
	public void CheckEmailCode(String email, HttpSession http) throws UnsupportedEncodingException {
		
		email = URLDecoder.decode(email, "UTF-8");
		
		mailSendService.SendMail(email, http);
		
	}
	
	@PostMapping("/mailcheck")
	public Map<String, Object> mailCheck(Integer enteredCode, HttpSession http) {
		Boolean ok = mailSendService.compareNum(enteredCode, http);
		
		return Map.of("authentication", ok);
	}
	
	@GetMapping("/searchmail/{email}")
	public Map<String, Object> checkMailId(@PathVariable String email, Authentication authentication) {
		
		return mailSendService.checkMailId(email, authentication);
	}

}
