package com.aula.seguro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity 
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
				 .requestMatchers(HttpMethod.GET,"/produtos").hasAnyRole("USER","ADMIN")
				 .requestMatchers(HttpMethod.POST,"/produtos").hasRole("ADMIN")
				 .anyRequest()
			     .authenticated())
				 .httpBasic(Customizer.withDefaults())
				 .build();
	}

}
