package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Material;

public class RecursoBuilder implements ItemBuilder {
    @Override
    public Material criar(String nome){
        return  switch (nome){
            case "Graveto" ->  new Material("Graveto",0.5,1,null);
            case "Madeira" -> new Material("Graveto",2,1,"Machado");
            case "Pedra" -> new Material("Pedra", 1, 1, null);
            case "Rocha" -> new Material("Rocha", 4, 1, "Picatera");
            default -> new Material("Vazio",0,1,null);
        };
    }
}
