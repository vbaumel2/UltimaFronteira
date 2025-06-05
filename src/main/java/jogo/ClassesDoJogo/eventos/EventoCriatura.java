package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.itens.Arma;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;

public class EventoCriatura extends Evento {

    private double vida;
    private double dano;
    private Item drop;
    private Runnable runnable;

    public EventoCriatura(String nome, double peso, double vida, double dano, Item drop) {
        super(nome, peso);
        this.vida = vida;
        this.dano = dano;
        this.drop = drop;
    }

    public Item getDrop() {
        return drop;
    }


    private boolean checkMorrer(Ambiente ambiente, Mapa mapa){
        if(vida<=0){
            Globals.getMainWindow().addTexto("Você matou o(a)"+getNome(), "orange");
            if(drop!=null){
                Globals.getMainWindow().addTexto("A criatura deixou "+ drop.getNome()+" no ambiente");
                ambiente.addItems(List.of(drop));
                if(runnable!=null) mapa.removeRunnable(runnable);
            }

            return  true;
        }
        return  false;
    }

    private void combate(Ambiente ambiente, Jogador jogador, Mapa mapa){
        Arma arma = jogador.getArmaEquipada();
        double danoArma =1;
        if(arma!=null) danoArma = arma.getDano();
        vida-=danoArma;
        Globals.getMainWindow().addTexto("Você encontra um(a) "+ getNome()+ ". Você a ataca por \n"+
                danoArma+"de dano. Agora ela esta com "+vida+" pontos de vida.", "orange"
        );
        if(!checkMorrer(ambiente, mapa)){
            jogador.addVida(-dano, getNome()+" te ataca por "+dano+" pontos de vida!");
        }
    }


    @Override
    public void aplicarEvento(Jogador jogador, Mapa mapa){
        Ambiente ambiente = getAmbiente();
        ambiente.removeEvento(this);

        runnable = ()->{
          if(mapa.getAmbienteAtual()==ambiente){
              combate(ambiente, jogador, mapa);
          } else {
              mapa.removeRunnable(runnable);
              runnable = null;
              ambiente.addEvento(this);
          }
        };

        mapa.addRunnable(runnable);
    }

}