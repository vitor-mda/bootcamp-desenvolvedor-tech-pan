package desafio.dto.request;

import desafio.entity.Venda;
import desafio.entity.Vendedor;

import java.time.LocalDate;

public class VendaRequest {
    private Long vendedorId;
    private Double valor;
    private LocalDate data;

    public Long getVendedorId() {
        return vendedorId;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Venda toEntity() {
        return new Venda(new Vendedor(this.vendedorId), this.valor, this.data);
    }
}