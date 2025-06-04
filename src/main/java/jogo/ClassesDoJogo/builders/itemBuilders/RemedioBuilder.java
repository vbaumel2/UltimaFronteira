package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Remedio;

public class RemedioBuilder implements ItemBuilder {
    public Remedio criar(String nome){
        return switch (nome){
            case "Bandagem" ->  new Remedio("Bandagem", 0.2, 1, 10);
            case "Ervas_medicinais" -> new Remedio("Ervas medicinais", 0.1, 1, 6);
            case "Argila" -> new Remedio("Argila", 0.3, 1, 4);
            case "Mel_silvestre" -> new Remedio("Mel silvestre", 0.15, 1, 8);
            case "Folhas_cicatrizantes" -> new Remedio("Folhas cicatrizantes", 0.12, 1, 5);
            case "Compressa_de_água_fria" -> new Remedio("Compressa de água fria", 0.18, 1, 3);
            default -> new Remedio("Vazio",0,1,0);
        };
    }
}
