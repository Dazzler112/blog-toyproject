package com.toyblog.blog_toyproject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;

@Slf4j
@Service
public class MailSendService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private BlogMailMapper blogMailMapper;
	
	@Autowired
	private BlogMemberMapper blogMemberMapper;
	
	public void SendMail(String email, HttpSession http) {
		
//	    if (email == null || email.isEmpty()) {
//	        throw new IllegalArgumentException("Email address cannot be null or empty.");
//	    }
		
		ArrayList<String> toUserList = new ArrayList<>();
		
		toUserList.add(email);
		
		int toUserSize = toUserList.size();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
		
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		
		log.info("randomNumber: {}", randomNumber);
		log.info("Received email: {}", email);
		
		simpleMessage.setSubject("GamesReview Mail 인증");
		simpleMessage.setText("Hello user! \n" + "this code write website \n" + 
							"\n" + "code number : " + randomNumber + "\n");
		
		javaMailSender.send(simpleMessage);
		
		http.setAttribute("authenticateNum", randomNumber);
	}
	
	public Map<String, Object> checkMailId(String email, Authentication authentication) {
		Members member = blogMailMapper.selectByCheckEmailId(email);

		if (authentication != null) {
		    Members ordinaryMember = blogMemberMapper.selectByMemberId(authentication.getName());
		    return Map.of("available", ordinaryMember == null || ordinaryMember.getEmail().equals(email));
		}else {
		        return Map.of("available", member == null);
		}
	}

	public Boolean compareNum(Integer enteredCode, HttpSession http) {
		
		Object num = http.getAttribute("authenticateNum");
		
		if(enteredCode.equals(num)) {
			System.out.println("enteredCode true=> " + enteredCode);
			return true;
		} else {
			System.out.println("enteredCode false=> " + enteredCode);
			return false;
		}
	}

}
