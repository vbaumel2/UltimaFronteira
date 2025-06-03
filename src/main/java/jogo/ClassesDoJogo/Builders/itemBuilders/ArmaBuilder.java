package jogo.ClassesDoJogo.Builders.itemBuilders;

import jogo.ClassesDoJogo.Builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Arma;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.ClassesDoJogo.itens.Ferramenta;

public class ArmaBuilder implements ItemBuilder {

    public Arma criar(String nome){
        return switch(nome){
            default -> new Arma("Vazio",0,1,0);
        };
    }
}
