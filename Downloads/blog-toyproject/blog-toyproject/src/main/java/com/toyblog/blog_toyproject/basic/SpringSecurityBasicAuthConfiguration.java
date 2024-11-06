package com.toyblog.blog_toyproject.basic;

import java.util.*;

import org.apache.ibatis.type.*;
import org.mybatis.spring.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

@Configuration
@MapperScan("com.toyblog.blog_toyproject.mapper")
public class SpringSecurityBasicAuthConfiguration {
	
    @Bean
    public TypeHandler<List<String>> stringListTypeHandler() {
        return new StringListTypeHandler();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//추후에 사용
//		http.formLogin()
//				.loginPage("").defaultSuccessUrl(null);
//		http.logout()
//				.logoutUrl("").logoutSuccessUrl(null);
		
		return http
				.authorizeHttpRequests(
						auth -> 
							auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//							.anyRequest().authenticated()						
							.anyRequest().permitAll()
							)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(
						session -> session.sessionCreationPolicy
									(SessionCreationPolicy.STATELESS)
						)
				.csrf().disable()
				.build();
	}
	
}
