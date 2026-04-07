package meu.curso.microservicos.pedido.controller;

import meu.curso.microservicos.pedido.model.Pedido;
import meu.curso.microservicos.pedido.services.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoService pedidoService;
    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    public PedidoController(RabbitTemplate rabbitTemplate, PedidoService pedidoService) {
        this.pedidoService = pedidoService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvar(pedido);
        rabbitTemplate.convertAndSend("",routingKey, pedidoSalvo.getDescricao());
        return "Pedido salvo e enviado para processamento: " + pedido.getDescricao();
    }

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }
}
