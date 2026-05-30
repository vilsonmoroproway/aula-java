package com.aula.seguro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aula.seguro.modelos.Usuario;
import com.aula.seguro.repositories.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService{
    @Autowired
	UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario =
				 repository.findByUsername(username)
				 .orElseThrow(() ->
				 new UsernameNotFoundException("Usuário não encontrado"));
				 		
		return User.builder()
				 .username(usuario.getUsername())
				 .password(usuario.getPassword())
				 .roles(usuario.getRole())
				 .build();
	}
	
    
}
