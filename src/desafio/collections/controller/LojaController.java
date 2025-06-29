package desafio.collections.controller;

import desafio.collections.model.Loja;
import desafio.collections.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class LojaController {
    private List<Loja> lojas;
    private Loja selectedLoja;

    public LojaController(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public Produto selectProduto(String cod){
        if(selectedLoja != null){
            return selectedLoja.selectProduto(cod);
        }
        return null;
    }

    public Loja selectLoja(String nome){
        for(Loja loja: lojas){
            if(loja.getNome().equalsIgnoreCase(nome)){
                selectedLoja = loja;
                return loja;
            }
        }
        return null;
    }
}
