package desafio.service;

import desafio.dto.request.ItemPedidoRequest;
import desafio.dto.request.PedidoRequest;
import desafio.dto.response.ItemPedidoResponse;
import desafio.dto.response.PedidoResponse;
import desafio.entity.ItemPedido;
import desafio.entity.Pedido;
import desafio.entity.Produto;
import desafio.repository.ItemPedidoRepository;
import desafio.repository.PedidoRepository;
import desafio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido save(Pedido entity) {
        entity.getItens().forEach(item -> {
            item.setPedido(entity);
            item.getProduto().addItem(item);
        });
        Pedido savedPedido = pedidoRepository.save(entity);
        itemPedidoRepository.saveAll(savedPedido.getItens());

        return savedPedido;
    }

    public Pedido updateSituacao(Pedido oldEntity, Pedido newEntity) {
        oldEntity.setSituacao(newEntity.getSituacao());
        Pedido updatedEntity = pedidoRepository.save(oldEntity);

        return updatedEntity;
    }

    public Pedido toEntity(PedidoRequest request) {
        return new Pedido(
                request.getDataHora(),
                request.getSituacao(),
                request.getItens()
                        .stream()
                        .map(this::toEntity)
                        .collect(toList())
        );
    }

    public PedidoResponse toResponse(Pedido entity) {
        return new PedidoResponse(
                entity.getId(),
                entity.getDataHora(),
                entity.getSituacao(),
                entity.getItens()
                        .stream()
                        .map(this::toResponse)
                        .collect(toList())
        );
    }

    private ItemPedido toEntity(ItemPedidoRequest request) {
        Produto produto = produtoRepository.findById(request.getIdProduto()).get();
        ItemPedido itemPedido = new ItemPedido(
                produto,
                request.getQuantidade());
        return itemPedido;
    }

    private ItemPedidoResponse toResponse(ItemPedido entity) {
        return new ItemPedidoResponse(
                entity.getId().getIdProduto(),
                entity.getQuantidade()
        );
    }
}