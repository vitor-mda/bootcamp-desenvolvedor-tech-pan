import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent {

  constructor(private dialogRef: MatDialogRef<ConfirmComponent>) {}

  public fechar(limpar: boolean): void {
    this.dialogRef.close(limpar);
  }
}