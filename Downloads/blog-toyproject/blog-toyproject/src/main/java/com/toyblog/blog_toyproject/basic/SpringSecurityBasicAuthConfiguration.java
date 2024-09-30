package com.toyblog.blog_toyproject.basic;

import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.web.*;

@Configuration
public class SpringSecurityBasicAuthConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						auth -> 
							auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
							.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(
						session -> session.sessionCreationPolicy
									(SessionCreationPolicy.STATELESS)
						)
				.csrf().disable()
				.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
