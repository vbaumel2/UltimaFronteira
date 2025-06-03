package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;

public abstract class Evento {
    private String nome;
    private double peso;
    public Evento(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }


    public double getPeso(){
        return peso;
    }

    public abstract void aplicarEvento(Ambiente ambiente, Jogador jogador, Mapa mapa);
}