package com.comercial.agenda.controllers;

import com.comercial.agenda.modelos.Contato;
import com.comercial.agenda.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    ContatoService service;
    private List<Contato> lista = new ArrayList<>();

    public ContatoController(){
      lista.add(new Contato(1l,"maria","maria@gmail.com"));
      lista.add(new Contato(2l,"ana","ana@gmail.com"));
    }

    @GetMapping
    public  ResponseEntity<Object> listar(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Long id){
        try{
           return ResponseEntity.status(HttpStatus.OK).body(service.listarUm(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody Contato contato){
        try{
            contato = service.salvar(contato);
            return ResponseEntity.status(HttpStatus.CREATED).body(contato);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public Object alterar(@PathVariable Long id, @RequestBody Contato contato){
        try{
            contato = service.alterar(id, contato);
            return ResponseEntity.status(HttpStatus.OK).body(contato);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
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
