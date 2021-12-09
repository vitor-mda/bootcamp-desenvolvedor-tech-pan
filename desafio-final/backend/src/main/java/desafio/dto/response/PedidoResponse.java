package desafio.dto.response;

import desafio.enums.Situacao;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponse {
    private Long id;
    private LocalDateTime dataHora;
    private Situacao situacao;
    private List<ItemPedidoResponse> itens;

    public PedidoResponse(Long id, LocalDateTime dataHora, Situacao situacao, List<ItemPedidoResponse> itens) {
        this.id = id;
        this.dataHora = dataHora;
        this.situacao = situacao;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public List<ItemPedidoResponse> getItens() {
        return itens;
    }
}
