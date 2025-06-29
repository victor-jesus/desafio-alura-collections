package desafio.collections.model;

public class Produto implements Comparable<Produto> {
    String nome;
    double valor;
    Loja loja;

    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public Produto(String nome, double valor, Loja loja) {
        this(nome, valor);
        this.loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public Loja getLoja() {
        return loja;
    }

    @Override
    public String toString() {
        return this.getNome() + ", R$" + this.getValor() + " (" + this.loja.getNome() + ")\n";
    }

    @Override
    public int compareTo(Produto other) {
        return Double.compare(this.getValor(), other.getValor());
    }
}
