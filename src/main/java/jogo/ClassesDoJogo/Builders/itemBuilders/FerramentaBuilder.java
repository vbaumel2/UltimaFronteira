package jogo.ClassesDoJogo.Builders.itemBuilders;

import jogo.ClassesDoJogo.Builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.ClassesDoJogo.itens.Ferramenta;

public class FerramentaBuilder implements ItemBuilder {

    public Ferramenta criar(String nome){
        return switch(nome){
            default -> new Ferramenta("Vazio",0,1,"vazio");
        };
    }
}
