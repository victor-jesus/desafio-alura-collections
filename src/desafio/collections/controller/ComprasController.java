package desafio.collections.controller;

import desafio.collections.model.Carrinho;
import desafio.collections.model.CartaoCompra;

public class ComprasController{
    CartaoCompra cartaoCompra;


    public ComprasController(CartaoCompra cartaoCompra) {
        this.cartaoCompra = cartaoCompra;
    }

    public void comprar(Carrinho carrinho){
        cartaoCompra.comprar(carrinho);
    }
}
