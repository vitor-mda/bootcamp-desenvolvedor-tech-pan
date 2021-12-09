package desafio.repository;

import desafio.entity.ItemPedido;
import desafio.entity.ItemPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoId> {
}