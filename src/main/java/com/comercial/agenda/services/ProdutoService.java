package com.comercial.agenda.services;

import com.comercial.agenda.modelos.Contato;
import com.comercial.agenda.modelos.Produto;
import com.comercial.agenda.repositories.ContatoRepository;
import com.comercial.agenda.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto salvar(Produto prod){
        return repository.save(prod);
    }

    public Produto alterar(Long id, Produto prod){
        Produto produto = listarUm(id);

        produto.setDescricao(prod.getDescricao());
        produto.setPreco(prod.getPreco());
        produto.setEstoque(prod.getEstoque());

        return repository.save(produto);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto listarUm(Long id){
        Optional<Produto> opt = repository.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("O produto informado não existe"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
