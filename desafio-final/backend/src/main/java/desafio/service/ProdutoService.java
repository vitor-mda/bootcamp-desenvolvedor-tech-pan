package desafio.service;

import desafio.dto.response.ProdutoResponse;
import desafio.entity.Produto;
import desafio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public ProdutoResponse toResponse(Produto entity) {
        return new ProdutoResponse(
                entity.getId(),
                entity.getCategoria(),
                entity.getDescricao(),
                entity.getPreco()
        );
    }
}
