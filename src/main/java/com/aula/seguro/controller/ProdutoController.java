package com.aula.seguro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos") 
public class ProdutoController {
	@GetMapping
	public List<String> listar() {
		 return List.of(
		 "Notebook",
		 "Mouse",
		 "Teclado"
		 );
    } 
	
	@PostMapping
	public String inserir(@RequestBody String dado) {
		 return "produto inserido com sucesso";
    } 
}
