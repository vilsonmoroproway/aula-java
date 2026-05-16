package com.comercial.agenda.services;

import com.comercial.agenda.modelos.Contato;
import com.comercial.agenda.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    ContatoRepository repository;

    public Contato salvar(Contato ct){
        if(ct.getNome().trim().equals("")){
            throw  new RuntimeException("O nome deve ser informado");
        }
        if(ct.getEmail().trim().equals("")){
            throw  new RuntimeException("O email deve ser informado");
        }
        return repository.save(ct);
    }

    public Contato alterar(Long id, Contato ct){
        Contato contato = listarUm(id);

        if(ct.getNome().trim().equals("")){
            throw  new RuntimeException("O nome deve ser informado");
        }
        if(ct.getEmail().trim().equals("")){
            throw  new RuntimeException("O email deve ser informado");
        }
        contato.setNome(ct.getNome());
        contato.setEmail(ct.getEmail());
        return repository.save(contato);
    }

    public List<Contato> listar(){
        return repository.findAll();
    }

    public Contato listarUm(Long id){
        Optional<Contato> opt = repository.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("O contato informado não existe"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
