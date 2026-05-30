package com.aula.seguro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.seguro.config.JwtService;
import com.aula.seguro.dto.LoginResponse;
import com.aula.seguro.dto.UsuarioDTO;
import com.aula.seguro.modelos.Usuario;
import com.aula.seguro.repositories.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;
    
    @Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO request) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()));

        String token = jwtService.gerarToken(auth.getName());
        return ResponseEntity.ok().body(new LoginResponse(token));
    }
    
    @PostMapping("/register")
	public Usuario cadastrar(@RequestBody Usuario usuario) {
	  usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	  return repository.save(usuario);
	} 
}
