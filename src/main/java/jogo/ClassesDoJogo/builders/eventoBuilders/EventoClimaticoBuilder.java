package jogo.ClassesDoJogo.builders.eventoBuilders;

import jogo.ClassesDoJogo.builders.EventoBuilder;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoClimatico;

public class EventoClimaticoBuilder implements EventoBuilder {

    public Evento criar(String nome){
        return switch (nome){
            case "Tempestade_areia" -> new EventoClimatico("Tempestade de areia", 4, 3, 3, 3);
            case "Nevasca" -> new EventoClimatico("Nevasca", 4, 4, 5, 3);
            case "Deslizamento" -> new EventoClimatico("Deslizamento", 1, 1, 1, 7);
            case "Chuva intensa" -> new EventoClimatico("Chuva intensa", 4, 4, 3, 0);
            case "Tempestade" -> new EventoClimatico("Tempestade", 3, 4, 3, 2);
            case "Armardilhas" -> new EventoClimatico("Armadilhas", 1, 1, 0 , 7);
            default -> new EventoClimatico("Nada", 1, 1, 0, 0);
        };
    }
}
