package jogo.ClassesDoJogo.builders.eventoBuilders;

import jogo.ClassesDoJogo.builders.EventoBuilder;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoCriatura;

public class EventoCriaturaBuilder implements EventoBuilder {

    public Evento criar(String nome){
        return switch (nome){
            //String nome, double peso, int duracao, double vida, double dano, Item drop
            case "Lobo" -> new EventoCriatura("Lobo", 0.8, 2, 8, 2, null);
            case "Urso" -> new EventoCriatura("Urso", 1.5, 3, 20, 5, null);
            case "Morcego" -> new EventoCriatura("Morcego", 0.3, 1, 3, 1, null);
            case "Sobrevivente_Hostil" -> new EventoCriatura("Sobrevivente Hostil", 1.0, 2, 10, 3, null);
            default -> new EventoCriatura("Nada", 1, 1, 1, 0, null);
        };
    }
}
