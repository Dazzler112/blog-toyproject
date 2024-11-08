package com.toyblog.blog_toyproject.basic;

import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

@Configuration
@EnableMethodSecurity
//@MapperScan("com.toyblog.blog_toyproject.mapper")
public class SpringSecurityBasicAuthConfiguration {
	
	//TypeHandler 사용해야 할 시 필요 authority를 List로 넣어줘야할 이유를 찾지 못했기 때문에 주석처리
	/*
	 * @Bean public TypeHandler<List<String>> stringListTypeHandler() { return new
	 * StringListTypeHandler(); }
	 */
	
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
