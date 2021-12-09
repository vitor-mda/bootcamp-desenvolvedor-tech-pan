package desafio.controller;

import desafio.dto.response.ProdutoResponse;
import desafio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cardapio")
@Transactional(readOnly = true)
public class ProdutoController {
    @Autowired
    private ProdutoService produto;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return ResponseEntity.ok(
                produto.findAll()
                        .stream()
                        .map(produto::toResponse)
                        .collect(Collectors.toList()));
    }
}