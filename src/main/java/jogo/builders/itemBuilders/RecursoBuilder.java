package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Material;

public class RecursoBuilder implements ItemBuilder {
    @Override
    public Material criar(String nome){
        return  switch (nome){
            case "Graveto" ->  new Material("Graveto",0.5,1,null);
            case "Madeira" -> new Material("Madeira",2,1,"machado");
            case "Pedra" -> new Material("Pedra", 1, 1, null);
            case "Rocha" -> new Material("Rocha", 4, 1, "picareta");
            case "Areia" -> new Material("Areia", 0.3, 1, null);
            case "Ferro" -> new Material("Ferro", 3, 1, "picareta");
            case "Plantas" -> new Material("Plantas", 0.7, 1, null);
            case "Vegetação" -> new Material("Vegetação", 1.0, 1, "pá");
            default -> new Material("Vazio",0,1,null);
        };
    }
}
