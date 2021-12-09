package desafio.dto.request;

import desafio.enums.Situacao;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoRequest {
    private LocalDateTime dataHora;
    private Situacao situacao;
    private List<ItemPedidoRequest> itens;

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public Situacao getSituacao() {
        return this.situacao;
    }

    public List<ItemPedidoRequest> getItens() {
        return this.itens;
    }
}