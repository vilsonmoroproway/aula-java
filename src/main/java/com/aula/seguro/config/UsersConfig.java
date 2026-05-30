package com.aula.seguro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UsersConfig {

/*	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("123")).roles("ADMIN")
				.build();

		UserDetails user = User.builder().username("joao").password(passwordEncoder().encode("123")).roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
}
