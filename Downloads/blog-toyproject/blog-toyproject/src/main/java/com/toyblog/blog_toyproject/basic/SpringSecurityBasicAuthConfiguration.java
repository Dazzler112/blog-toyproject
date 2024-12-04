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
import org.springframework.security.web.util.matcher.*;

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
									(SessionCreationPolicy.IF_REQUIRED)
						)
				.csrf().disable()
				
				.formLogin((formLogin) ->
				formLogin
					.loginPage("/1")
//					.usernameParameter("username")
//					.passwordParameter("password")
					.defaultSuccessUrl("/about",true)
				)
				
				//추후에 사용
				.logout((logoutConfig) ->
				logoutConfig.logoutRequestMatcher(new AntPathRequestMatcher("/0/0"))
					.logoutSuccessUrl("/about")
					.invalidateHttpSession(true) //.invalidateHttpSession(true)를 통해 로그아웃 시 생성된 사용자 세션도 삭제 
				)
		
				.build();
	}
	
}
