package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Arma;

public class ArmaBuilder implements ItemBuilder {

    public Arma criar(String nome){
        return switch(nome){
            case "Faca" -> new Arma("Faca", 0.5, 3, 2);
            case "Faca_Improvisada" -> new Arma("Faca Improvisada", 0.3, 2, 1.5);
            case "Lança_Improvisada" -> new Arma("Lança Improvisada", 0.7, 3, 2);
            case "Graveto_afiado" -> new Arma("Graveto afiado", 0.4, 1, 1);
            case "Espada" -> new Arma("Espada", 1.2, 4, 3);
            case "Espada_Improvisada" -> new Arma("Espada Improvisada", 0.8, 3, 2);
            case "Lança" -> new Arma("Lança", 1.0, 3, 2.5);
            default -> new Arma("Vazio",0,1,0);
        };
    }
}
