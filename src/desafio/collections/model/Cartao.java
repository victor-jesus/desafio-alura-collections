package desafio.collections.model;

public class Cartao {
    String banco;
    int numero;
    int cvv;
    double limite;
    Pessoa pessoa;

    public Cartao(String banco, int numero, int cvv, double limite, Pessoa pessoa) {
        this.banco = banco;
        this.numero = numero;
        this.cvv = cvv;
        this.limite = limite;
        this.pessoa = pessoa;
    }

    public void imprimeCartao(){
        System.out.println("Cartão do " + this.banco + "\nLimite: " + this.getLimite());
    }

    public String getBanco() {
        return banco;
    }

    public int getNumero() {
        return numero;
    }

    public int getCvv() {
        return cvv;
    }

    public double getLimite() {
        return limite;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "banco='" + banco + '\'' +
                ", numero=" + numero +
                ", cvv=" + cvv +
                ", limite=" + limite +
                ", pessoa=" + pessoa.getNome() +
                '}';
    }
}
