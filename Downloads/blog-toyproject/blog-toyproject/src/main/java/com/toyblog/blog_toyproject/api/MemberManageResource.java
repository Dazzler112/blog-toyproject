package com.toyblog.blog_toyproject.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.web.bind.annotation.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.service.*;

@RestController
public class MemberManageResource {

	@Autowired
	private BlogMemberManageService blogMemberManageService;
	
	@PostMapping("/manage/block/{member_id}")
	public ResponseEntity<Map<String, Object>>userBlock(@PathVariable String member_id
														,@RequestBody Map<String, String> requestBody // ✅ JSON에서 member_type 받기
														,Authentication authentication) {
		
		String member_type = requestBody.get("member_type"); // ✅ JSON 데이터에서 가져오기
		
		Members members = new Members();
		members.setMember_type(member_type);
		members.setMember_id(member_id);
		
		Map<String, Object> result = blogMemberManageService.setUserBlock(members);
		
		if(result != null) {
			System.err.println("완료 : " + result);
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
	
	@PostMapping("/manage/remove/{member_id}")
	public ResponseEntity<Map<String, Object>> userRemove(@PathVariable String member_id
														  ,@RequestBody Map<String, String> requestBody
														  ,Authentication authentication) {
		
		String member_type = requestBody.get("member_type");
		
		Members member = new Members();
		member.setMember_type(member_type);
		member.setMember_id(member_id);
		
		Map<String, Object> result = blogMemberManageService.setUserRemove(member);
		
		if(result != null) {
			System.out.println("성공" + result);
			return ResponseEntity.ok(result);
		} else {
			System.out.println(result);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
}
