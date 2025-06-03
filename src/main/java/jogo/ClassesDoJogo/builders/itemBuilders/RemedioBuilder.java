package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Remedio;

public class RemedioBuilder implements ItemBuilder {
    public Remedio criar(String nome){
        return switch (nome){
            case "Bandagem" ->  new Remedio("Bandagem", 0.2, 1, 10);
            default -> new Remedio("Vazio",0,1,0);
        };
    }
}
