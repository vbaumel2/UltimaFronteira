package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Arma;

public class ArmaBuilder implements ItemBuilder {

    public Arma criar(String nome){
        return switch(nome) {
            case "Faca" -> new Arma("Faca", 0.5, 4, 4);
            case "Faca Improvisada" -> new Arma("Faca Improvisada", 0.3, 2, 3);

            case "Graveto afiado" -> new Arma("Graveto afiado", 0.4, 1, 1);

            case "Espada" -> new Arma("Espada", 1.2, 4, 8);
            case "Espada Improvisada" -> new Arma("Espada Improvisada", 0.8, 3, 6);

            case "Lança" -> new Arma("Lança", 1.0, 7, 7);
            case "Lança Improvisada" -> new Arma("Lança Improvisada", 0.7, 5, 5);

            case "Arco" -> new Arma("Arco", 1.0, 3, 10);
            case "Arco Improvisado" -> new Arma("Arco Improvisado", 0.6, 3, 8);

            default -> new Arma("Vazio", 0, 1, 0);
        };
    }
}
