package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.ambientes.Ambiente;

import java.util.List;
import java.util.Random;

public class GerenciadorEventos {
    private Ambiente ambiente;
    private double probabilidade;

    public GerenciadorEventos(Ambiente ambiente, double probabilidade){
        this.ambiente = ambiente;
        this.probabilidade = probabilidade;
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

    public void tentarEventos(){
        if (Math.random()>=probabilidade) return;
        if (ambiente.getEventos() == null || ambiente.getEventos().isEmpty()) return;

        escolherEvento(ambiente.getEventos()).aplicarEvento(ambiente);
    }


}
