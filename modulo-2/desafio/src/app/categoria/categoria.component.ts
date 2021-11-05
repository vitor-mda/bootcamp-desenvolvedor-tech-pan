import { Component, HostListener, Input } from '@angular/core';
import { Produto } from '../produto';

@Component({
  selector: 'categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent {
  @Input()
  public nome: string = "";

  @Input()
  public produtos: Produto[] = [];
}