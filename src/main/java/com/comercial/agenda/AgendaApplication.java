package com.comercial.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
/*
* Controller -> receber a requisição
* Service -> processa a requisição (regra de negócio)
* Repository -> persitência (acesso ao banco de dados)
* Modelo -> classe do modelo (dados)
 */