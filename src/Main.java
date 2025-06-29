import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Victor");
        nomes.add("Rayssa");
        nomes.add("Ailson");
        nomes.add("Maria");

        nomes.forEach(System.out::println);
        Collections.sort(nomes);
        nomes.forEach(System.out::println);

        Filmes filme1 = new Filmes("Django", 2012);
        Filmes filme3 = new Filmes("Alice no país das maravilhas", 1990);
        Filmes filme2 = new Filmes("O Poderoso Chefão", 1970);

        List<Filmes> filmes = new ArrayList<>();
        filmes.add(filme1);
        filmes.add(filme3);
        filmes.add(filme2);


        System.out.println(filmes);
        Collections.sort(filmes);
        System.out.println(filmes);
        filmes.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println(filmes);
    }
}