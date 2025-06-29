package desafio.collections.controller;

import desafio.collections.model.CarrinhoInterface;
import desafio.collections.model.Cartao;
import desafio.collections.model.Produto;

public class CarrinhoController {
    CarrinhoInterface carrinho;

    public CarrinhoController(CarrinhoInterface carrinho) {
        this.carrinho = carrinho;
    }

    public boolean existeItem(int cod) {
        return carrinho.existeItem(cod);
    }

    public void comprar(Cartao cartao){
        carrinho.comprar(cartao);
    }

    public void esvaziaCarrinho() {
        carrinho.esvaziaCarrinho();
    }

    public void addItem(Produto produto) {
        carrinho.addItem(produto);
    }

    public void removeItem(Produto produto) {
        carrinho.removeItem(produto);
    }

    public double precoCarrinho() {
        return carrinho.precoCarrinho();
    }

    public void imprimeCarrinho() {
        carrinho.imprimeCarrinho();
    }
}
