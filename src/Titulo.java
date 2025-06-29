import java.util.Comparator;

public abstract class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoLancamento;

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoLancamento() + ")";
    }

    @Override
    public int compareTo(Titulo o) {
        return Integer.compare(o.getAnoLancamento(), this.getAnoLancamento());
    }

}
