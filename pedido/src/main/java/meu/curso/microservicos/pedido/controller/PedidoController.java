package meu.curso.microservicos.pedido.controller;

import meu.curso.microservicos.pedido.model.Pedido;
import meu.curso.microservicos.pedido.services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        pedidoService.salvar(pedido);
        return "Pedido salvo e enviado para processamento: " + pedido.getDescricao();
    }

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }
}
