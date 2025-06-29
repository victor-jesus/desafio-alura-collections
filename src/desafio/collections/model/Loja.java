package desafio.collections.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loja {
    String nome;
    Map<Integer, Produto> itens;

    public Loja(String nome){
        this.nome = nome;
        itens = new HashMap<>();
    }

    public Loja(Map<Integer, Produto> produtos) {
        super();
        this.itens = produtos;
    }

    public boolean existeProduto(String nome){
        if (this.nome.equalsIgnoreCase(nome)){
            return true;
        }
        return false;
    }

    public Map<Integer, Produto> getProdutos() {
        return itens;
    }

    public Produto selectProduto(String cod){
        if(Integer.parseInt(cod) >= 0 && Integer.parseInt(cod) <= 9){
            for(Map.Entry<Integer, Produto> produtoEntry : itens.entrySet()){
                if(produtoEntry.getKey().toString().equalsIgnoreCase(cod)) {
                    return produtoEntry.getValue();
                }
            }

        }
        return null;
    }

    public void imprimeProdutos(){
        itens.forEach((integer, produto) -> System.out.println(integer + " - " + produto.getNome() + " R$" + produto.getValor()));
    }

    public void addProduto(int cod, Produto produto) {
        itens.put(cod, produto);
    }

    public void addProduto(Map<Integer, Produto> listaProdutos) {
        itens.putAll(listaProdutos);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nome=" + nome +
                '}';
    }
}
