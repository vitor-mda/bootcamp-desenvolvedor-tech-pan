package desafio.controller;

import desafio.dto.request.VendedorRequest;
import desafio.dto.response.VendedorResponse;
import desafio.entity.Vendedor;
import desafio.service.VendedorService;
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
@RequestMapping("/vendedor")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorResponse>> findAll() {
        List<VendedorResponse> response = vendedorService.findAll()
                .stream()
                .map(VendedorResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorResponse> findById(@PathVariable Long id) {
        Vendedor vendedor = vendedorService.findById(id);
        return vendedor != null ?
                ResponseEntity.ok(new VendedorResponse(vendedor)) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<VendedorResponse>> findAllOrderByTotalDeVendas() {
        List<VendedorResponse> response = vendedorService.findAllOrderByTotalDeVendas()
                .stream()
                .map(VendedorResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VendedorResponse> save(@RequestBody VendedorRequest novoVendedor) {
        Vendedor vendedor = vendedorService.save(novoVendedor.toEntity());
        return ResponseEntity
                .created(URI.create("/" + vendedor.getId()))
                .body(new VendedorResponse(vendedor));
    }
}