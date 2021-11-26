package desafio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendedor vendedor;

    private Double valor;
    private LocalDate data;

    public Venda() {}

    public Venda(Vendedor vendedor, Double valor, LocalDate data) {
        this.vendedor = vendedor;
        this.valor = valor;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}