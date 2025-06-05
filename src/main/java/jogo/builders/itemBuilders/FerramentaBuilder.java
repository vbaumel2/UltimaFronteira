package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Ferramenta;

public class FerramentaBuilder implements ItemBuilder {

    public Ferramenta criar(String nome){
        return switch(nome) {
            case "Machado improvisado" -> new Ferramenta("Machado improvisado", 1.5, 2, "machado", 1);
            case "Machado" -> new Ferramenta("Machado", 2, 5, "machado", 2);

            case "Lanterna" -> new Ferramenta("Lanterna", 1, 6, "lanterna", 4);
            case "Tocha" -> new Ferramenta("Tocha", 1, 2, "lanterna", 1);

            case "Pá improvisada" -> new Ferramenta("Pá improvisada", 0.7, 2, "pá", 1);
            case "Pá" -> new Ferramenta("Pá", 1.2, 4, "pá", 1.8);

            case "Picareta improvisada" -> new Ferramenta("Picareta improvisada", 1.0, 2, "picareta", 1);
            case "Picareta" -> new Ferramenta("Picareta", 2.5, 4, "picareta", 2);

            default -> new Ferramenta("Vazio", 0, 1, "vazio", 1);
        };
    }
}
