package com.pedido.pedido.controles;

import com.pedido.pedido.PedidoService;
import com.pedido.pedido.modelos.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> realizarPedido(@RequestBody Pedido pedido) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.realizarPedido(pedido));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.CREATED).body(ex.getMessage());
        }
    }
}
