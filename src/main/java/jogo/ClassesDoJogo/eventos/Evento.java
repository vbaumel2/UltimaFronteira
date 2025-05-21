package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.ambientes.Ambiente;

public abstract class Evento {
    private String descricao;
    private double peso;
    public Evento(String descricao, double peso) {
        this.descricao = descricao;
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso(){
        return peso;
    }

    public abstract void aplicarEvento(Ambiente ambiente);
}