package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.ambientes.Ambiente;

public class Terremoto extends Evento {
    public Terremoto(String descricao, int impacto) {
        super(descricao, impacto);
    }

    @Override
    public void aplicarEvento(Ambiente ambiente) {
        System.out.println("Terremoto sacode o ambiente: " + ambiente.getNome());
    }
}

