package com.aula.seguro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aula.seguro.modelos.Usuario;
import com.aula.seguro.repositories.UsuarioRepository;

@SpringBootApplication
public class SeguroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguroApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository repository,
	                       PasswordEncoder encoder) {
	    return args -> {

	        if(repository.findByUsername("admin").isEmpty()) {

	            Usuario admin = new Usuario();
	            admin.setUsername("admin");
	            admin.setPassword(encoder.encode("123"));
	            admin.setRole("ADMIN");

	            repository.save(admin);
	        }
	    };
	}
}
