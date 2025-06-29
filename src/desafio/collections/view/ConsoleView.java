package desafio.collections.view;

import desafio.collections.controller.CarrinhoController;
import desafio.collections.controller.ComprasController;
import desafio.collections.controller.LojaController;
import desafio.collections.model.*;

import java.sql.SQLOutput;
import java.util.*;

public class ConsoleView {
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        Pessoa pessoa = new Pessoa("Victor");
        Carrinho carrinho = new Carrinho(pessoa);
        Loja kabum = new Loja("Kabum");
        Loja pichau = new Loja("Pichau");
        List<Loja> lojas = Arrays.asList(kabum, pichau);
        LojaController lojaController = new LojaController(lojas);

        Produto ps5Digital = new Produto("PS5 Digital", 3000, kabum);
        Produto ps5Fisico = new Produto("PS5 Fisico", 3500, kabum);
        Produto xboxSeriesS = new Produto("Xbox Series S", 2500, kabum);
        Produto xboxSeriesX = new Produto("Xbox Series X", 4000, kabum);

        Cartao cartao = new Cartao("Itau", 55246724, 132, 10000, pessoa);

        kabum.addProduto(Map.of(1, ps5Digital, 2, ps5Fisico, 3, xboxSeriesX, 4, xboxSeriesS));

        CarrinhoController carrinhoController = new CarrinhoController(carrinho);

        String option;

        pessoa.setCarrinho(carrinho);
        pessoa.setCartoes(List.of(cartao));

        do {
            System.out.println("---- Digite o nome da loja que deseja entrar ----\n");
            System.out.println("--- Lojas ----");
            lojas.forEach(loja -> System.out.println(loja.getNome()));
            System.out.print("Digite: ");
            option = scanner.next();

            Loja selectedLoja = lojaController.selectLoja(option);

            System.out.println("---- Lista de Produtos ----");
            selectedLoja.imprimeProdutos();
            System.out.print("Digite o código do item que deseja comprar: ");
            option = scanner.next();

            Produto selectedProduto = lojaController.selectProduto(option);

            carrinhoController.addItem(selectedProduto);
            carrinhoController.imprimeCarrinho();

        } while (!option.equalsIgnoreCase("Sair") || !option.equalsIgnoreCase("0"));



//        List<Cartao> cartoes = new ArrayList<>();
//        cartoes.add(cartao);
//        pessoa.setCartoes(cartoes);
//        pessoa.setCarrinho(carrinho);
//
//        System.out.println(kabum);
    }
}
