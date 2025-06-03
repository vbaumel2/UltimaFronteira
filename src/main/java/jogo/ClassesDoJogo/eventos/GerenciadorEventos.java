package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;

import java.util.List;
import java.util.Random;

public class GerenciadorEventos {
    private Mapa mapa;

    public GerenciadorEventos(Mapa mapa){
        this.mapa = mapa;
    }

    private double probabilidadeEventos(Ambiente ambiente){
        double q = ambiente.getEventos().size();
        return q/(q+3);
    }

    private Evento escolherEvento(List<Evento> eventos){

        double pesoTotal = 0;
        for(Evento e:eventos){
            pesoTotal+= e.getPeso();
        }
        double r = pesoTotal*Math.random();
        double soma = 0;
        for(Evento evento:eventos){
            soma += evento.getPeso();
            if(r< soma) return evento;
        }

        return eventos.getLast();
    }

    public void tentarEventos(Ambiente ambiente){

        if (Math.random()>probabilidadeEventos(ambiente)) return;
        if (ambiente.getEventos() == null || ambiente.getEventos().isEmpty()) return;

        escolherEvento(ambiente.getEventos()).aplicarEvento(ambiente, mapa.getJogador(), mapa);
    }


}
