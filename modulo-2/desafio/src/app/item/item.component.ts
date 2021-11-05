import { Component, HostListener, Input, OnInit } from '@angular/core';
import { PedidoService } from '../pedido.service';
import { Produto } from '../produto';

@Component({
  selector: 'item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Input()
  public produto: Produto = {descricao: '', preco: 0, categoria: ''};
  public noCarrinho: boolean = false;
  public selecionado: boolean = false;

  constructor(private pedidoService: PedidoService) {}

  @HostListener('click')
  public onClick(): void {
    this.selecionado = true;
  }

  @HostListener('mouseleave')
  public onMouseLeave(): void {
    this.selecionado = false;
  }

  ngOnInit(): void {
    this.noCarrinho = this.pedidoService.quantidadeNoPedido(this.produto) > 0;
  }
}