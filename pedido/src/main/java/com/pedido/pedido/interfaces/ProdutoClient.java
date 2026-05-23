package com.pedido.pedido.interfaces;


import com.pedido.pedido.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "produto-api",
        url = "http://localhost:8081")
public interface ProdutoClient {

    @GetMapping("/produtos/{id}")
    ProdutoDTO buscarProduto( @PathVariable Long id);

    @PutMapping("/produtos/{id}/estoque")
    void atualizarEstoque(@PathVariable Long id,
            @RequestParam Integer quantidade);
}
