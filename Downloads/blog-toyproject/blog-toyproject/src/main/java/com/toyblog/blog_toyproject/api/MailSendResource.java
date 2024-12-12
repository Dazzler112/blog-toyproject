package com.toyblog.blog_toyproject.api;

import java.io.*;
import java.net.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

import jakarta.servlet.http.*;

@RestController
public class MailSendResource {

	@Autowired
	private MailSendService mailSendService;
	
	@Autowired
	private BlogMemberService blogMemberService;
	
	@PostMapping("/mail/code")
	public ResponseEntity<Map<String, Object>> CheckEmailCode(String email, HttpSession http, Members member) throws UnsupportedEncodingException {
		
		email = URLDecoder.decode(email, "UTF-8");
		
		String memberId = blogMemberService.findMemberId(member);
		if(memberId == null) {
			throw new RuntimeException("No member found with email: " + email);
		}
		
		mailSendService.SendMail(email, http);
		
		http.setAttribute("memberId", memberId);
		
		Map<String, Object> response = new HashMap<>();
		response.put("memberId", memberId);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/mailcheck")
	public ResponseEntity<Map<String, Object>> mailCheck(Integer enteredCode, HttpSession http) {
		Boolean ok = mailSendService.compareNum(enteredCode, http);
		
		Integer authenticateNum = (Integer) http.getAttribute("authenticateNum");
		String memberId = (String) http.getAttribute("memberId");
		
		Map<String, Object> response = new HashMap<>();
	    response.put("authentication", authenticateNum != null && authenticateNum.equals(Integer.valueOf(enteredCode)));
	    response.put("memberId", memberId);
	    
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/searchmail/{email}")
	public Map<String, Object> checkMailId(@PathVariable String email, Authentication authentication) {
		
		return mailSendService.checkMailId(email, authentication);
	}

}
