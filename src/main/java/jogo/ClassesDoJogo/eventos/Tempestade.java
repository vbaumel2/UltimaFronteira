package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.ambientes.Ambiente;

public class Tempestade extends Evento {
    public Tempestade(String descricao, int impacto) {
        super(descricao, impacto);
    }

    @Override
    public void aplicarEvento(Ambiente ambiente) {
        System.out.println("Tempestade atinge o ambiente: " + ambiente.getNome());
    }
}
