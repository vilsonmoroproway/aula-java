package com.pedido.pedido;

import com.pedido.pedido.dto.ProdutoDTO;
import com.pedido.pedido.modelos.Pedido;
import com.pedido.pedido.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final WebClient webClient;


    public PedidoService(
            PedidoRepository repository,
            WebClient webClient) {

        this.repository = repository;
        this.webClient = webClient;
    }
    public Pedido realizarPedido(Pedido pedido) {
        ProdutoDTO produto = webClient
                .get()
                .uri("/produtos/{id}", pedido.getIdProduto())
                .retrieve()
                .bodyToMono(ProdutoDTO.class)
                .block();

        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }

        // VERIFICA ESTOQUE
        if(produto.getEstoque() < pedido.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        // CALCULA NOVO ESTOQUE
        int novoEstoque =  produto.getEstoque() - pedido.getQuantidade();

        // ATUALIZA ESTOQUE
        webClient.put()
                .uri(uriBuilder ->
                         uriBuilder
                                .path("/produtos/{id}/estoque")
                                .queryParam(
                                        "quantidade",
                                        novoEstoque)
                                .build(produto.getId()))
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        // SALVA PEDIDO
        return repository.save(pedido);
    }
}
