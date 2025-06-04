package jogo.ClassesDoJogo.builders.eventoBuilders;

import jogo.ClassesDoJogo.builders.EventoBuilder;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoDescoberta;
import jogo.ClassesDoJogo.itens.Antidoto;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.Globals;

import java.util.List;

public class EventoExploracaoBuilder implements EventoBuilder {

    public Evento criar(String nome){
        return switch (nome){
            case "Explorador_morto" -> new EventoDescoberta("Explorador morto", 3, List.of(
                    Globals.Bebidas.criar("Agua_grande"),
                    Globals.Alimentos.criar("Rações"),
                    Globals.Ferramentas.criar("Lanterna"),
                    Globals.Armas.criar("Faca"),
                    Globals.Remedios.criar("Bandagem"),
                    new Antidoto()
            ));
            default -> new EventoDescoberta("Nada", 1, List.of());
        };
    }
}