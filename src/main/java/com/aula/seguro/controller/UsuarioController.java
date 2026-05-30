package com.aula.seguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.seguro.modelos.Usuario;
import com.aula.seguro.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')") 
	public Usuario cadastrar(@RequestBody Usuario usuario) {
	  usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	  return repository.save(usuario);
	} 

}
