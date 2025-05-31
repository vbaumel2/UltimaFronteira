package jogo.ClassesDoJogo.eventos.EventoCriatura;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.Globals;

public class InvasaoAnimal extends Evento {
    public InvasaoAnimal(String descricao, double peso) {
        super(descricao, peso);
    }

    @Override
    public void aplicarEvento(Ambiente ambiente, Jogador jogador) {
        Globals.getMainWindow().addTexto( getDescricao()+" invadem o "+ambiente.getNome()+"!\n"+
                "Você toma 7 de dano.", "yellow");
        jogador.addVida(-7);
    }
}