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
    public Object getOne(@PathVariable Long id){
        Contato ct = procurarUm(id);
        if(ct != null){
            return ct;
        }
        return "O contato não existe";
    }

    @PostMapping
    public Contato gravar(@RequestBody Contato contato){
        contato.setId(lista.size()+1l);
        lista.add(contato);
        return contato;
    }
    @PutMapping("/{id}")
    public Object alterar(@PathVariable Long id, @RequestBody Contato contato){
        Contato ct = procurarUm(id);
        if(ct != null){
           ct.setNome(contato.getNome());
           ct.setEmail(contato.getEmail());
           return "Contato alterado com sucesso";
        }
        return "O contato não existe";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        Contato ct = procurarUm(id);
        if(ct != null){
            lista.remove(ct);
            return "Contato excluido com sucesso";
        }
        return "O contato não existe";
    }

    private Contato procurarUm(Long id){
        for(Contato c : lista){
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

}
