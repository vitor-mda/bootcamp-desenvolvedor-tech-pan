import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ConfirmComponent } from '../confirm/confirm.component';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent {
  constructor(public pedidoService: PedidoService, private dialog: MatDialog) {}

  public limpar(): void {
    let dialogRef: MatDialogRef<ConfirmComponent> = this.dialog.open(ConfirmComponent);
    
    dialogRef
      .afterClosed()
      .subscribe(deveLimpar => {
        if(deveLimpar) {
          this.pedidoService.limpar();
        }
      });
  }
}