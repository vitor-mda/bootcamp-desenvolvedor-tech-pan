package desafio.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemPedidoId implements Serializable {
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_produto")
    private Long idProduto;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedidoId)) return false;
        ItemPedidoId that = (ItemPedidoId) o;
        return Objects.equals(this.idPedido, that.idPedido) &&
                Objects.equals(this.idProduto, that.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idPedido, this.idProduto);
    }
}