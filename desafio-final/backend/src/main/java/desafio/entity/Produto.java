package desafio.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    List<ItemPedido> itens;

    public Produto() {}

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, String categoria, String descricao, Double preco) {
        this.id = id;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return this.id;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Double getPreco() {
        return this.preco;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void addItem(ItemPedido item) {
        if(itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(item);
    }
}