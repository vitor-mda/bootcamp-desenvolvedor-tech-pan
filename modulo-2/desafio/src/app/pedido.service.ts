import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Pedido } from './pedido';
import { Produto } from './produto';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  private readonly urlBase: string = "http://localhost:3000";
  public cardapio: Observable<Produto[]>;
  public pedidos: Pedido[] = [];
  public quantidadeProdutos: number = 0;
  public precoTotal: number = 0;

  constructor(private http: HttpClient) {
    this.cardapio = this.http.get<Produto[]>(`${this.urlBase}/cardapio`);
  }

  public adicionarProduto(produto: Produto): void {
    for(let pedido of this.pedidos) {
      if(pedido.produto.descricao == produto.descricao) {
        pedido.quantidade++;
        pedido.precoTotal += produto.preco;
        this.quantidadeProdutos++;
        this.precoTotal += produto.preco;
        return;
      }
    }

    this.pedidos.push({precoTotal: produto.preco, quantidade: 1, produto});
    this.quantidadeProdutos++;
    this.precoTotal += produto.preco;
  }
  
  public removerProduto(produto: Produto): void {
    for(let i = 0; i < this.pedidos.length; i++) {
      if(this.pedidos[i].produto.descricao == produto.descricao) {
        if(this.pedidos[i].quantidade > 1) {
          this.pedidos[i].quantidade--;
          this.pedidos[i].precoTotal -= produto.preco;
        } else {
          this.pedidos.splice(i, 1);
        }
        this.precoTotal -= produto.preco;
        this.quantidadeProdutos--;
      }
    }
  }

  public quantidadeNoPedido(produto: Produto): number {
    let quantidade = 0;

    for(let pedido of this.pedidos) {
      if(pedido.produto.descricao == produto.descricao) {
        quantidade = pedido.quantidade;
      }
    }

    return quantidade;
  }

  public limpar(): void {
    this.pedidos = [];
    this.quantidadeProdutos = 0;
    this.precoTotal = 0;
  }
}