package desafio.controller;

import desafio.dto.request.PedidoRequest;
import desafio.dto.response.PedidoResponse;
import desafio.entity.Pedido;
import desafio.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/pedido")
@Transactional
public class PedidoController {
    @Autowired
    private PedidoService pedido;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<PedidoResponse>> findAll() {
        return ResponseEntity.ok(
                pedido.findAll()
                        .stream()
                        .map(pedido::toResponse)
                        .collect(toList()));
    }

    @GetMapping("/{idPedido}")
    @Transactional(readOnly = true)
    public ResponseEntity<PedidoResponse> findById(@PathVariable Long idPedido) {
        Pedido pedido = this.pedido.findById(idPedido);

        return pedido != null ?
                ResponseEntity.ok(this.pedido.toResponse(pedido)) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> save(@RequestBody PedidoRequest pedidoRequest) {
        Pedido savedEntity = pedido.save(pedido.toEntity(pedidoRequest));
        PedidoResponse response = pedido.toResponse(savedEntity);

        return ResponseEntity
                .created(URI.create("/" + savedEntity.getId()))
                .body(response);
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<PedidoResponse> updateSituacao(@PathVariable Long idPedido, @RequestBody PedidoRequest pedidoRequest) {
        Pedido oldEntity = pedido.findById(idPedido);

        if(oldEntity != null) {
            Pedido newEntity = pedido.toEntity(pedidoRequest);
            Pedido updatedEntity = pedido.updateSituacao(oldEntity, newEntity);

            return ResponseEntity.ok(pedido.toResponse(updatedEntity));
        }
        return ResponseEntity.notFound().build();
    }
}