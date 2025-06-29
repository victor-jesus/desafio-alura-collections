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
        if (produto != null) {
            itens.put(++id, produto);
            System.out.println("Item Adicionado com sucesso!");
        } else {
            System.out.println("Item não existe");
        }
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
    public String toString() {
        if(!itens.isEmpty()){
            System.out.println("Carrinho do " + this.pessoa.getNome());
            for(Map.Entry<Integer, Produto> itensCarrinho : itens.entrySet()){
                return itensCarrinho.getKey() + " - " + itensCarrinho.getValue();
            }
        }

        return "Carrinho Vazio";
    }

    @Override
    public void comprar(Cartao cartao) {
        double valorCompra = this.precoCarrinho();
        if(cartao.limite > valorCompra){
            System.out.println("Compra realizada com sucesso");
            cartao.limite -= valorCompra;
            esvaziaCarrinho();
        } else {
            System.out.println("Limite insuficiente.");
            System.out.println("Limite: " + cartao.limite);
            System.out.println("Valor da compra: " + valorCompra);
        }
    }
}
