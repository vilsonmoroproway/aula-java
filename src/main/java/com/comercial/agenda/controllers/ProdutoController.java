package com.comercial.agenda.controllers;

import com.comercial.agenda.modelos.Contato;
import com.comercial.agenda.modelos.Produto;
import com.comercial.agenda.services.ContatoService;
import com.comercial.agenda.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService service;
    private List<Contato> lista = new ArrayList<>();

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
       /* try{
           return ResponseEntity.status(HttpStatus.OK).body(service.listarUm(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        return ResponseEntity.status(HttpStatus.OK).body(service.listarUm(id));
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid Produto produto){
       /* try{
            produto = service.salvar(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        produto = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
    @PutMapping("/{id}")
    public Object alterar(@PathVariable Long id, @RequestBody @Valid Produto produto){
       /* try{
            produto = service.alterar(id, produto);
            return ResponseEntity.status(HttpStatus.OK).body(produto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
        produto = service.alterar(id, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
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
