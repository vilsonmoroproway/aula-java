package com.pedido.pedido;

import com.pedido.pedido.dto.ProdutoDTO;
import com.pedido.pedido.modelos.Pedido;
import com.pedido.pedido.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final RestTemplate restTemplate;

    public PedidoService(
            PedidoRepository repository,
            RestTemplate restTemplate) {

        this.repository = repository;
        this.restTemplate = restTemplate;
    }
    public Pedido realizarPedido(Pedido pedido) {

        String urlProduto = "http://localhost:8081/produtos/" + pedido.getIdProduto();

        // CONSULTA API PRODUTO
        ProdutoDTO produto = restTemplate.getForObject(urlProduto, ProdutoDTO.class);

        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");
        }

        // VERIFICA ESTOQUE
        if (produto.getEstoque() < pedido.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }
       // NOVO ESTOQUE
        Integer novoEstoque = produto.getEstoque() - pedido.getQuantidade();

        // ATUALIZA ESTOQUE
        String urlAtualizar = "http://localhost:8081/produtos/"
                        + produto.getId()
                        + "/estoque?quantidade="
                        + novoEstoque;

        restTemplate.put(urlAtualizar, null);

        // SALVA PEDIDO
        return repository.save(pedido);
    }
}
