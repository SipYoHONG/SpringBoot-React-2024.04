package com.example.project.reactProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(auth -> auth.disable())			
			.headers(x -> x.frameOptions(y -> y.disable()))		
			.authorizeHttpRequests(auth -> auth
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/user/register", "/react/**",
						"/img/**", "/css/**", "/js/**", "/error/**").permitAll()  // permitAll이란 (괄호) 안에 있는건 다 통과해주겠다라는 의미
				.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
			);
		
		return http.build();
	}
}
