package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.itens.Arma;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;

public class EventoCriatura extends Evento {

    private int duracao;
    private double vida;
    private double dano;
    private Item drop;
    private Runnable runnable;

    public EventoCriatura(String nome, double peso, int duracao, double vida, double dano, Item drop) {
        super(nome, peso);
        this.duracao = duracao;
        this.vida = vida;
        this.dano = dano;
        this.drop = drop;
    }

    public Item getDrop() {
        return drop;
    }


    private boolean checkMorrer(Ambiente ambiente, Mapa mapa){
        if(vida<=0){
            Globals.getMainWindow().addTexto("Você matou o(a)"+getNome());
            if(drop!=null){
                Globals.getMainWindow().addTexto("A criatura deixou "+ drop.getNome()+" no ambiente");
                ambiente.addItems(List.of(drop));
                if(runnable!=null) mapa.removeRunnable(runnable);
            }

            return  true;
        }
        return  false;
    }

    private void receberAtaque(Ambiente ambiente, Jogador jogador){
        Arma arma = jogador.getArmaEquipada();
        double dano =1;
        if(arma!=null) dano = arma.getDano();
        vida-=dano;
        Globals.getMainWindow().addTexto("Você encontra um(a) "+ getNome()+ ". Você a ataca por \n"+
                dano+"de dano. Agora ela esta com "+vida+" pontos de vida.", "orange"
        );
    }


    @Override
    public void aplicarEvento(Jogador jogador, Mapa mapa){
        Ambiente ambiente = getAmbiente();
        ambiente.removeEvento(this);

        receberAtaque(ambiente, jogador);
        if (checkMorrer(ambiente, mapa)) return;
        jogador.addVida(-dano, getNome()+" te ataca por "+ dano+ "pontos de vida e volta ao ambiente.");

        runnable = ()->{
          if(mapa.getAmbienteAtual()==ambiente){
              receberAtaque(ambiente, jogador);
              checkMorrer(ambiente, mapa);
          } else {
              mapa.removeRunnable(runnable);
              runnable = null;
              ambiente.addEvento(this);
          }
        };

        mapa.addRunnable(runnable);
    }

}