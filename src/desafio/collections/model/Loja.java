package desafio.collections.model;

import java.util.*;

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
        return this.nome.equalsIgnoreCase(nome);
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
        List<Produto> produtos = new ArrayList<>();
        for(Map.Entry<Integer, Produto> produto : itens.entrySet()){
            produtos.add(produto.getValue());
        }
        produtos.sort(Comparator.comparing(Produto::getValor));
        System.out.println(produtos);

        // itens.forEach((integer, produto) -> System.out.println(integer + " - " + produto.getNome() + " R$" + produto.getValor()));
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
