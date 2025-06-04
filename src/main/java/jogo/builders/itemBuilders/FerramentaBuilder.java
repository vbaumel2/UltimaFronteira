package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Ferramenta;

public class FerramentaBuilder implements ItemBuilder {

    public Ferramenta criar(String nome){
        return switch(nome){
            case "Machado_madeira" -> new Ferramenta("Machado de madeira", 1.5, 2, "machado", 1);
            case "Machado_pedra" -> new Ferramenta("Machado de pedra", 2.5, 3, "machado", 1.5);
            case "Machado_ferro" -> new Ferramenta("Machado de Ferro", 2, 5, "machado", 2);

            case "Lanterna" -> new Ferramenta("Lanterna", 1, 5, "lanterna", 4);
            case "Tocha" -> new Ferramenta("Tocha", 1, 5, "lanterna", 4);

            case "Pederneira" -> new Ferramenta("Pederneira", 0.1, 5, "fogo", 2);

            case "Pá_improvisada" -> new Ferramenta("Pá improvisada", 0.7, 2, "pá", 1);
            case "Pá_pedra" -> new Ferramenta("Pá de pedra", 0.7, 2, "pá", 1);
            default -> new Ferramenta("Vazio",0,1,"vazio", 1);
        };
    }
}
