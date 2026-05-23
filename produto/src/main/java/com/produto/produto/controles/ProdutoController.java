package com.produto.produto.controles;

import com.produto.produto.modelos.Produto;
import com.produto.produto.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController( ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @GetMapping("/{id}")
    public Produto buscar(
            @PathVariable Long id) {

        return service.buscar(id);
    }

    @PutMapping("/{id}/estoque")
    public Produto atualizarEstoque( @PathVariable Long id, @RequestParam Integer quantidade) {
        return service.atualizarEstoque(id,quantidade);
    }
}
