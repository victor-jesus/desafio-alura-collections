import java.util.Comparator;

public class TituloComparator implements Comparator<Titulo> {

    @Override
    public int compare(Titulo o1, Titulo o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
