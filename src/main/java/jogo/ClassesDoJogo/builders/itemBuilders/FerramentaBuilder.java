package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Ferramenta;

public class FerramentaBuilder implements ItemBuilder {

    public Ferramenta criar(String nome){
        return switch(nome){
            default -> new Ferramenta("Vazio",0,1,"vazio", 1);
        };
    }
}
