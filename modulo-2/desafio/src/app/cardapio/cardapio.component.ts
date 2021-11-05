import { AfterViewInit, Component, ElementRef, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { CategoriaComponent } from '../categoria/categoria.component';
import { PedidoService } from '../pedido.service';
import { Produto } from '../produto';

@Component({
  selector: 'cardapio',
  templateUrl: './cardapio.component.html',
  styleUrls: ['./cardapio.component.css']
})
export class CardapioComponent implements AfterViewInit {
  public produtos: Produto[] = [];
  public categorias: string[] = [];
  public estaCarregando: boolean = true;
  public indiceNavCategoriaAtual: number = -1;

  @ViewChild("divCategorias")
  private divCategorias!: ElementRef<HTMLDivElement>;

  @ViewChildren(CategoriaComponent, {read: ElementRef})
  public categoriaElements: QueryList<ElementRef> = new QueryList<ElementRef>();

  constructor(public pedidoService: PedidoService) {
    this.pedidoService.cardapio.subscribe(produtos => {
      this.produtos = produtos;
      
      for(let produto of produtos) {
        if(!this.categorias.includes(produto.categoria)) {
          this.categorias.push(produto.categoria);
        }
      }

      this.estaCarregando = false;
    });
  }

  public ngAfterViewInit(): void {
    let intersectionObserver: IntersectionObserver = new IntersectionObserver(entries => {
      entries.forEach((entry) => {
        
        if(entry.boundingClientRect.top <= 165) {
          let dataIndex: any = entry.target.getAttribute("data-index");
          dataIndex = dataIndex ? Number.parseInt(dataIndex) : 0;
          let indexAddend: number = this.indiceNavCategoriaAtual == dataIndex ? 1 : 0;
          this.indiceNavCategoriaAtual = dataIndex + indexAddend;
        }
      });
    });

    this.categoriaElements.changes.subscribe(value => {
      value.forEach((element: ElementRef) => {
        intersectionObserver.observe(element.nativeElement as HTMLElement);
      });
    });
  }

  public obterProdutosPorCategoria(categoria: string): Produto[] {
    return this.produtos.filter(produto => produto.categoria == categoria);
  }

  public scrollTo(index: number) {
    this.divCategorias.nativeElement.scrollTo({
      top: (this.categoriaElements.get(index)?.nativeElement as HTMLElement).offsetTop + 1,
      left: 0,
      behavior: "smooth"
    });
  }
}