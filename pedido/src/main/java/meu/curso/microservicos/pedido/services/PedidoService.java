package meu.curso.microservicos.pedido.services;

import meu.curso.microservicos.pedido.model.ItemPedido;
import meu.curso.microservicos.pedido.model.Pedido;
import meu.curso.microservicos.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvar(Pedido pedido) {
        if(pedido.getItens() != null){ // Verifica se o pedido possui itens associados
            for (ItemPedido item : pedido.getItens() ) { // Percorre cada item da lista de itens do pedido
                // Define o próprio pedido dentro de cada item
                // Isso é importante para manter o relacionamento bidirecional
                // (ou seja, o item sabe a qual pedido ele pertence)
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }


}
