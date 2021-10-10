import { Component, Input } from '@angular/core';

@Component({
  selector: 'selecao',
  templateUrl: './selecao.component.html' ,
  styleUrls: ['./selecao.component.css']
})
export class SelecaoComponent {
  @Input()
  titulo: string;

  @Input()
  opcoes: string[];

  @Input()
  limiteDeEscolhas: number;

  private indicesDasEscolhas: number[];

  numeroDeEscolhasFeitas: number;

  constructor() {
    this.titulo = '';
    this.opcoes = [];
    this.limiteDeEscolhas = 0;
    this.indicesDasEscolhas = [];
    this.numeroDeEscolhasFeitas = 0;
  }

  inputType(): string {
    return this.isCheckbox() ? 'checkbox' : 'radio';
  }

  handleChange(event : Event, index: number): void {
    if ((event.target as HTMLInputElement).checked) {
      this.indicesDasEscolhas.push(index);
      this.numeroDeEscolhasFeitas++;
    } else {
      let indiceNaLista = this.indicesDasEscolhas.indexOf(index);
      this.indicesDasEscolhas.splice(indiceNaLista, 1);
      this.numeroDeEscolhasFeitas--;
    }
  }

  isDisabled(index: number): boolean {
    return this.isCheckbox() ?
            this.numeroDeEscolhasFeitas === this.limiteDeEscolhas && !this.indicesDasEscolhas.includes(index) :
            false;
  }

  isCheckbox(): boolean {
    return this.limiteDeEscolhas > 1;
  }
}