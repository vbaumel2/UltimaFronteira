package jogo.builders;

import jogo.ClassesDoJogo.eventos.Evento;

public interface EventoBuilder {
    public abstract Evento criar(String nome);
}
