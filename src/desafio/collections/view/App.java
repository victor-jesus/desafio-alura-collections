package desafio.collections.view;

import desafio.collections.model.Carrinho;
import desafio.collections.model.CarrinhoInterface;
import desafio.collections.model.Cartao;
import desafio.collections.model.Pessoa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        consoleView.showMenu();
    }
}
