package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Bebida;

public class BebidaBuilder implements ItemBuilder {
    @Override
    public Bebida criar(String nome){
        return switch (nome){
            case "Garrafa de agua" ->  new Bebida("Garrafa", 0.2, 1, 10);
            case "Garrafa de agua grande" -> new Bebida("Garrafa grande", 0.5, 1,20);
            default -> new Bebida("Vazio",0,1,0);
        };
    }
}
