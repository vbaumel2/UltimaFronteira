package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Bebida;

public class BebidaBuilder implements ItemBuilder {
    @Override
    public Bebida criar(String nome){
        return switch (nome){
            case "Agua" ->  new Bebida("Agua", 0.2, 1, 10);
            case "Agua_grande" -> new Bebida("Agua grande", 0.5, 1,20);
            case "Seiva" -> new Bebida("Seiva", 0.12, 1, 4);
            case "Coco" -> new Bebida("Coco", 0.3, 1, 12);
            default -> new Bebida("Vazio",0,1,0);
        };
    }
}
