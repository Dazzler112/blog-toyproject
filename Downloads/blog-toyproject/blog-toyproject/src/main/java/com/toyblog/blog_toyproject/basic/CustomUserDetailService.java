package com.toyblog.blog_toyproject.basic;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import com.toyblog.blog_toyproject.dto.*;
import com.toyblog.blog_toyproject.mapper.*;

@Component
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private BlogMemberMapper blogMemberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
		
		Members member = blogMemberMapper.slectById(member_id);
		
		if (member == null) {
			throw new UsernameNotFoundException(member_id + "회원이 없습니다.");
		}
		
		UserDetails user = User.builder()
					.username(member.getMember_id())
					.password(member.getPassword())
					.authorities(Collections.singleton(new SimpleGrantedAuthority(member.getAuthority())))
					.build();
		
		return user;
	}
}
