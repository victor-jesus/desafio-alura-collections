package desafio.collections.model;

public interface CarrinhoInterface {
    void esvaziaCarrinho();
    void addItem(Produto produto);
    void removeItem(Produto produto);
    void imprimeCarrinho();
    double precoCarrinho();
    void comprar(Cartao cartao);
    boolean existeItem(int cod);

}
