package com.comercial.agenda.controllers;

import com.comercial.agenda.modelos.Contato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private List<Contato> lista = new ArrayList<>();

    public ContatoController(){
      lista.add(new Contato(1,"maria","maria@gmail.com"));
      lista.add(new Contato(2,"ana","ana@gmail.com"));
    }

    @GetMapping
    public List<Contato> ola(){
        return lista;
    }

}
