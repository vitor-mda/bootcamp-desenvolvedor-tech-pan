package desafio.dto.response;

public class ProdutoResponse {
    private Long id;
    private String categoria;
    private String descricao;
    private Double preco;

    public ProdutoResponse(Long id, String categoria, String descricao, Double preco) {
        this.id = id;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }
}