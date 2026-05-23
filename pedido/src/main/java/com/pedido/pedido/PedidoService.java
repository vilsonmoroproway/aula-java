package com.pedido.pedido;

import com.pedido.pedido.dto.ProdutoDTO;
import com.pedido.pedido.interfaces.ProdutoClient;
import com.pedido.pedido.modelos.Pedido;
import com.pedido.pedido.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    private ProdutoClient produtoClient;

    public PedidoService(
            PedidoRepository repository,
            ProdutoClient produtoClient) {

        this.repository = repository;
        this.produtoClient = produtoClient;
    }
    public Pedido realizarPedido(Pedido pedido) {

        ProdutoDTO produto = produtoClient.buscarProduto(pedido.getIdProduto());

        // VERIFICA ESTOQUE
        if(produto.getEstoque()
                < pedido.getQuantidade()) {

            throw new RuntimeException(
                    "Estoque insuficiente");
        }

        // CALCULA NOVO ESTOQUE
        int novoEstoque =
                produto.getEstoque()
                        - pedido.getQuantidade();

        // ATUALIZA ESTOQUE
        produtoClient.atualizarEstoque( produto.getId(), novoEstoque);


        // SALVA PEDIDO
        return repository.save(pedido);
    }
}
