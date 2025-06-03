package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Arma;

public class ArmaBuilder implements ItemBuilder {

    public Arma criar(String nome){
        return switch(nome){
            default -> new Arma("Vazio",0,1,0);
        };
    }
}
