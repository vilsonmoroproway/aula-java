package com.comercial.agenda.controllers;

import com.comercial.agenda.modelos.Contato;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Contato getOne(@PathVariable Long id){
        for(Contato ct : lista){
            if (ct.getId() == id)
                return  ct;
        }
        return null;
    }

    @PostMapping
    public Contato gravar(@RequestBody Contato contato){
        contato.setId(lista.size()+1l);
        lista.add(contato);
        return contato;
    }
    @PutMapping("/{id}")
    public Object alterar(@PathVariable Long id, @RequestBody Contato contato){
        Contato ct = null;

        for(Contato c : lista){
           if (c.getId() == id) {
               ct = c;
               break;
           }
        }
        if(ct != null){
           ct.setNome(contato.getNome());
           ct.setEmail(contato.getEmail());
           return "Contato alterado com sucesso";
        }
        return "O contato não existe";
    }
}
