package desafio.collections.model;

import java.util.HashMap;
import java.util.Map;

public class Carrinho implements CarrinhoInterface {
    Integer id = 0;
    Pessoa pessoa;
    Map<Integer, Produto> itens;

    public Carrinho(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.itens = new HashMap<>();
    }

    public Map<Integer, Produto> getItens() {
        return itens;
    }



    @Override
    public boolean existeItem(int cod) {
        return itens.containsKey(cod);
    }

    @Override
    public void esvaziaCarrinho() {
        itens.clear();
        id = 0;
    }

    @Override
    public void addItem(Produto produto) {
        itens.put(++id, produto);
    }

    @Override
    public void removeItem(Produto produto) {
        if(itens.containsValue(produto)) {
            itens.remove(produto);
            id--;
        } else {
            System.err.println("Não existe " + produto.getNome());
        }
    }

    @Override
    public double precoCarrinho() {
        double valor = 0.0;
        for(Map.Entry<Integer, Produto> item : itens.entrySet()){
            valor += item.getValue().getValor();
        }
        return valor;
    }

    @Override
    public void imprimeCarrinho() {
        if(!itens.isEmpty()){
            System.out.println("Carrinho do " + this.pessoa.getNome());
            for(Map.Entry<Integer, Produto> itensCarrinho : itens.entrySet()){
                System.out.println(itensCarrinho.getKey() + " - " + itensCarrinho.getValue());
            }
        } else {
            System.out.println("Carrinho Vazio");
        }
    }

    @Override
    public void comprar(Cartao cartao) {
        double valorCompra = this.precoCarrinho();
        if(cartao.limite > valorCompra){
            System.out.println("Compra realizada com sucesso");
            cartao.limite -= valorCompra;
            for(Map.Entry<Integer, Produto> itensCarrinho : itens.entrySet()){
                itens.forEach((cod, produto) -> itens.remove(itensCarrinho.getKey()));
            }
        } else {
            System.out.println("Limite insuficiente.");
            System.out.println("Limite: " + cartao.limite);
            System.out.println("Valor da compra: " + valorCompra);
        }
    }
}
