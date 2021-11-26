package desafio.dto.request;

import desafio.entity.Vendedor;

public class VendedorRequest {
    private String nome;

    public String getNome() {
        return nome;
    }

    public Vendedor toEntity() {
        return new Vendedor(this.getNome());
    }
}