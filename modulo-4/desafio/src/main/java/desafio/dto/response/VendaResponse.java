package desafio.dto.response;

import desafio.entity.Venda;

import java.time.LocalDate;

public class VendaResponse {
    private Long id;
    private LocalDate data;
    private Double valor;
    private Long vendedorId;

    public VendaResponse(Venda venda) {
        this.id = venda.getId();
        this.data = venda.getData();
        this.valor = venda.getValor();
        this.vendedorId = venda.getVendedor().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public Long getVendedorId() {
        return vendedorId;
    }
}