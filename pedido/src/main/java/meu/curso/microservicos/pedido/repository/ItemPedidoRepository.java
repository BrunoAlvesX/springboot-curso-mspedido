package meu.curso.microservicos.pedido.repository;


import meu.curso.microservicos.pedido.model.ItemPedido;
import meu.curso.microservicos.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
    
}
