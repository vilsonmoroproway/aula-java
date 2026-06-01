package com.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.agenda.modelos.Cliente;

@Controller
public class ClienteController {
	
	static List<Cliente> clientes = new ArrayList<Cliente>();
	
	List<String> linguagens = List.of(
		    "Java",
		    "JavaScript",
		    "Python",
		    "C#"
		);

		
	
	@GetMapping("/clientes")
	public String clientes(Model model) {
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setEmail("joao@gmail.com");

		model.addAttribute("cliente", cliente);
		
		return "clientes";

	}
	
	@GetMapping("/linguagens")
	public String linguagens(Model model) {
		model.addAttribute("linguagens", linguagens);
		return "clientes";

	}
	
	@GetMapping("/cadastro")
	public String formulario(Model model){

	    model.addAttribute("cliente", new Cliente());

	    return "novocliente";
	}
	
	 @PostMapping("/salvar")
	    public String salvar(Cliente cliente){
	        clientes.add(cliente);
	        return "redirect:/consulta";
	    }

	    @GetMapping("/consulta")
	    public String consulta(Model model){
	        model.addAttribute("clientes", clientes);
	        return "consulta";
	    }
}
