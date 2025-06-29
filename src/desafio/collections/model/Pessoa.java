package desafio.collections.model;

import java.util.List;

public class Pessoa {
    String nome;
    List<Cartao> cartoes;
    Carrinho carrinho;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, List<Cartao> cartoes) {
        this(nome);
        this.cartoes = cartoes;
    }

    public String getNome() {
        return nome;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cartoes=" + cartoes +
                ", carrinho=" + carrinho +
                '}';
    }
}
