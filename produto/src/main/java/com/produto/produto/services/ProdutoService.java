package com.produto.produto.services;

import com.produto.produto.ProdutoRepository;
import com.produto.produto.modelos.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto buscar(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Produto não encontrado"));
    }

    public Produto atualizarEstoque(Long id, Integer quantidade) {

        Produto produto = buscar(id);

        produto.setEstoque(quantidade);

        return repository.save(produto);
    }
}