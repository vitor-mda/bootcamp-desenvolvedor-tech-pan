package desafio.controller;

import desafio.dto.request.VendaRequest;
import desafio.dto.response.VendaResponse;
import desafio.entity.Venda;
import desafio.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaResponse>> findAll() {
        List<VendaResponse> response = vendaService.findAll()
                .stream()
                .map(VendaResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaResponse> findById(@PathVariable Long id) {
        Venda venda = vendaService.findById(id);
        return venda != null ?
                ResponseEntity.ok(new VendaResponse(venda)) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VendaResponse> save(@RequestBody VendaRequest novaVenda) {
        Venda venda = vendaService.save(novaVenda.toEntity());
        return ResponseEntity
                .created(URI.create("/" + venda.getId()))
                .body(new VendaResponse(venda));
    }
}