package desafio.dto.response;

public class ItemPedidoResponse {
    private Long idProduto;
    private Integer quantidade;

    public ItemPedidoResponse(Long idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
