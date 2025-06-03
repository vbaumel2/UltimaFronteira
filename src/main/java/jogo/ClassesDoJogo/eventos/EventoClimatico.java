package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.Globals;

public class EventoClimatico extends Evento {
    private int duracao;
    private double difficuldade;
    private double dano;

    public EventoClimatico(String nome, double peso, int duracao, double difficuldade, double dano) {
        super(nome, peso);
        this.duracao = duracao;
        this.difficuldade = difficuldade;
        this.dano = dano;
    }

    public void aplicarEvento(Ambiente ambiente, Jogador jogador, Mapa mapa){
        ambiente.removeEvento(this);
        ambiente.addDifficuldade(difficuldade);
        Globals.getMainWindow().addTexto("Você encontra um(a) "+ getNome()+" que irá durar "+ duracao+" rodadas.\n"+
                "Isso dificulta a exploração.", "orange");
        Runnable task = ()->{
            if(mapa.getAmbienteAtual() == ambiente){
                Globals.getMainWindow().addTexto(getNome()+ " continua a afetar o ambiente.", "orange");
                if(dano>0) jogador.addVida(-dano, "Você perde "+dano + " pontos de vida devido a "+ getNome());
            }
        };
        Runnable onEnd = ()->{
            if(mapa.getAmbienteAtual() == ambiente) Globals.getMainWindow().addTexto("Fim de "+getNome()+" nesse ambiente.", "orange");
          ambiente.addDifficuldade(-difficuldade);
          ambiente.addEvento(this);
        };
        mapa.addCappedRunnable(duracao, task, onEnd);
    };

}
