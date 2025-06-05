package jogo.builders.eventoBuilders;

import jogo.ClassesDoJogo.itens.Antidoto;
import jogo.Globals;
import jogo.builders.EventoBuilder;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoCriatura;

public class EventoCriaturaBuilder implements EventoBuilder {

    public Evento criar(String nome){
        return switch (nome){
            case "Lobo" -> new EventoCriatura("Lobo", 5, 6, 6, Globals.Alimentos.criar("Carne pequena"));
            case "Urso" -> new EventoCriatura("Urso", 3, 10, 12, Globals.Alimentos.criar("Carne grande"));
            case "Morcego" -> new EventoCriatura("Morcego", 2, 2, 3, null);
            case "Sobrevivente Hostil" -> new EventoCriatura("Sobrevivente Hostil", 10, 6, 10, new Antidoto());
            case "Jacaré" -> new EventoCriatura("Jacaré", 8, 8, 10, Globals.Alimentos.criar("Carne grande"));
            default -> new EventoCriatura("Nada", 1, 1, 1, null);
        };
    }
}
