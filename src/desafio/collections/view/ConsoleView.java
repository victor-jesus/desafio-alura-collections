package desafio.collections.view;

import desafio.collections.controller.CarrinhoController;
import desafio.collections.controller.LojaController;
import desafio.collections.model.*;

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
        System.out.println(cartao);
        kabum.addProduto(Map.of(1, ps5Digital, 2, ps5Fisico, 3, xboxSeriesX, 4, xboxSeriesS));

        CarrinhoController carrinhoController = new CarrinhoController(carrinho);

        String option;

        pessoa.setCarrinho(carrinho);
        pessoa.setCartoes(List.of(cartao));

        System.out.println("---- Digite o nome da loja que deseja entrar ----\n");
        System.out.println("--- Lojas ----");
        lojas.forEach(loja -> System.out.println(loja.getNome()));
        System.out.print("Digite: ");
        option = scanner.nextLine();
        Loja selectedLoja = lojaController.selectLoja(option);

        if(selectedLoja != null){
            do {
                System.out.println("---- Lista de Produtos de " + selectedLoja.getNome() + " ----");
                selectedLoja.imprimeProdutos();

                System.out.print("Digite o código do item que deseja comprar: ");
                option = scanner.nextLine();
                Produto selectedProduto = lojaController.selectProduto(option);
                carrinhoController.addItem(selectedProduto);


                System.out.println("Deseja visualizar os itens do carrinho?");
                System.out.println("1 - Sim");
                System.out.println("0 - Não");
                option = scanner.nextLine();

                System.out.println();
                switch (option){
                    case "1" -> carrinhoController.imprimeCarrinho();
                    case "0" -> {}
                    default -> System.out.println("Opção não reconhecida.");
                }

                System.out.println();
                System.out.println("Deseja adicionar mais algum item ao carrinho?");
                System.out.println("1 - Sim");
                System.out.println("0 - Não");
                option = scanner.nextLine();

                switch (option) {
                    case "0" -> {
                        if(!carrinho.getItens().isEmpty()){
                            System.out.println("Podemos seguir com a compra?");
                            System.out.println("1 - Sim");
                            System.out.println("0 - Não");
                            option = scanner.nextLine();
                        }
                        switch (option) {
                            case "1" -> {
                                option = "0";
                                carrinhoController.comprar(cartao);
                            }
                            case "0" -> carrinhoController.esvaziaCarrinho();
                            default -> System.out.println("Comando não reconhecido");
                        }
                    }
                    case "1" -> System.out.println("Prosseguindo...");
                }

            } while (Integer.parseInt(option) != 0);
        } else {
            System.err.println("Loja não existe");
        }

        System.out.println();
        
        cartao.imprimeCartao();

        
    }
}
