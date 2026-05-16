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
    @GetMapping
    public  ResponseEntity<Object> listar(){
      /*  try{
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Long id){
       /* try{
           return ResponseEntity.status(HttpStatus.OK).body(service.listarUm(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        return ResponseEntity.status(HttpStatus.OK).body(service.listarUm(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody Contato contato){
       /* try{
            contato = service.salvar(contato);
            return ResponseEntity.status(HttpStatus.CREATED).body(contato);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        contato = service.salvar(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }
    @PutMapping("/{id}")
    public Object alterar(@PathVariable Long id, @RequestBody Contato contato){
       /* try{
            contato = service.alterar(id, contato);
            return ResponseEntity.status(HttpStatus.OK).body(contato);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        contato = service.alterar(id, contato);
        return ResponseEntity.status(HttpStatus.OK).body(contato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
