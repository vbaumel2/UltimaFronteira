package jogo.ClassesDoJogo.builders.eventoBuilders;

import jogo.ClassesDoJogo.builders.EventoBuilder;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoClimatico;
import jogo.ClassesDoJogo.eventos.EventoDoencaFerimento;

public class EventoDoencaFerimentoBuilder implements EventoBuilder {

    public EventoDoencaFerimento criar(String nome){
        return switch (nome){
            case "Hipotermia" -> new EventoDoencaFerimento("Hipotermia", 3, 5, 2);
            default -> new EventoDoencaFerimento("Nada", 1, 1, 0);
        };
    }
}
