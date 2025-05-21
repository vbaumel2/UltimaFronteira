package jogo.ClassesDoJogo.eventos.EventoClimatico;

import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.Globals;

public class Tempestade extends Evento {
    public Tempestade(String descricao, double peso) {
        super(descricao, peso);
    }

    @Override
    public void aplicarEvento(Ambiente ambiente) {
        Globals.getMainWindow().addTexto( getDescricao()+" atinge o "+ambiente.getNome()+"!\n"+
                 "Você toma 5 de dano.", "yellow");
        Globals.getJogador().addVida(-5);
    }
}
