package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;

public abstract class Evento {
    private String nome;
    private double peso;
    private Ambiente ambiente;

    public Evento(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public String getNome() {
        return nome;
    }


    public double getPeso(){
        return peso;
    }

    public abstract void aplicarEvento(Jogador jogador, Mapa mapa);
}