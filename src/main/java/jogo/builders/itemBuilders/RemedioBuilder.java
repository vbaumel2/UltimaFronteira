package jogo.builders.itemBuilders;

import jogo.ClassesDoJogo.itens.Item;
import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Remedio;

public class RemedioBuilder implements ItemBuilder {
    public Remedio criar(String nome){
        return switch (nome){
            case "Bandagem" ->  new Remedio("Bandagem", 0.2, 1, 10);
            case "Ervas medicinais" -> new Remedio("Ervas medicinais", 0.1, 1, 6);
            case "Mel silvestre" -> new Remedio("Mel silvestre", 0.15, 1, 8);
            case "Folhas cicatrizantes" -> new Remedio("Folhas cicatrizantes", 0.12, 1, 5);
            default -> new Remedio("Vazio",0,1,0);
        };
    }
}
