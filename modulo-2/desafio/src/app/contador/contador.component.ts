import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { PedidoService } from '../pedido.service';
import { Produto } from '../produto';

@Component({
  selector: 'contador',
  templateUrl: './contador.component.html',
  styleUrls: ['./contador.component.css']
})
export class ContadorComponent implements OnInit {
  @Input()
  public produto: Produto = {descricao: '', preco: 0, categoria: ''};

  @Input()
  public noCarrinho: boolean = false;

  @Output()
  public noCarrinhoChange: EventEmitter<boolean> = new EventEmitter<boolean>();
  
  public contagem: number = 0;

  constructor(public pedidoService: PedidoService) {}

  public adicionarProduto(produto: Produto): void {
    this.pedidoService.adicionarProduto(produto)
    this.contagem++;
    
    if(this.contagem == 1) {
      this.noCarrinhoChange.emit(true);
    }
  }

  public removerProduto(produto: Produto): void {
    this.pedidoService.removerProduto(produto);
    this.contagem--;

    if(this.contagem == 0) {
      this.noCarrinhoChange.emit(false);
    }
  }

  ngOnInit(): void {
    this.contagem = this.pedidoService.quantidadeNoPedido(this.produto);
    this.noCarrinhoChange.emit(this.contagem > 0);
  }
}