package desafio.dto.response;

import desafio.entity.Venda;
import desafio.entity.Vendedor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VendedorResponse {
    private Long id;
    private String nome;
    private List<VendaResponse> vendas;

    public VendedorResponse(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        List<Venda> vendas = vendedor.getVendas();

        if(vendas != null) {
            this.vendas = vendas.stream()
                    .map(venda -> new VendaResponse(venda))
                    .collect(Collectors.toList());
        } else {
            this.vendas = Collections.emptyList();
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<VendaResponse> getVendas() {
        return vendas;
    }
}