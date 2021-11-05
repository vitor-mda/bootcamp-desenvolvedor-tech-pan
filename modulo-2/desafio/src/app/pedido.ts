import { Produto } from "./produto";

export interface Pedido {
    precoTotal: number,
    quantidade: number,
    produto: Produto
}
