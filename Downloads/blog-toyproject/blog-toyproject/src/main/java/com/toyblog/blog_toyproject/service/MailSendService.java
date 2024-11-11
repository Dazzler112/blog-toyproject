package com.toyblog.blog_toyproject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.*;

import jakarta.servlet.http.*;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void SendMail(String email, HttpSession http) {
		
		ArrayList<String> toUserList = new ArrayList<>();
		
		toUserList.add(email);
		
		int toUserSize = toUserList.size();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
		
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		
		simpleMessage.setSubject("GamesReview Mail 인증");
		simpleMessage.setText("Hello user \n" + "this code write website \n" + 
							"\n" + "code number : " + randomNumber + "\n");
		
		javaMailSender.send(simpleMessage);
		
		http.setAttribute("authenticateNum", randomNumber);
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
