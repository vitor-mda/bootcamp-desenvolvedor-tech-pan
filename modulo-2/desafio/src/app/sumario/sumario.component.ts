import { Component } from '@angular/core';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'sumario',
  templateUrl: './sumario.component.html',
  styleUrls: ['./sumario.component.css']
})
export class SumarioComponent {

  constructor(public pedidoService: PedidoService) { }
}
