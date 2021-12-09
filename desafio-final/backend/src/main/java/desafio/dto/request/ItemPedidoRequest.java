package desafio.dto.request;

public class ItemPedidoRequest {
    private Long idProduto;
    private Integer quantidade;

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}