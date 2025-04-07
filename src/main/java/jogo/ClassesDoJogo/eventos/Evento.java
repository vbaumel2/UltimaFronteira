package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.ambientes.Ambiente;

public abstract class Evento {
    private String descricao;
    private int impacto;

    public Evento(String descricao, int impacto) {
        this.descricao = descricao;
        this.impacto = impacto;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImpacto() {
        return impacto;
    }

    public abstract void aplicarEvento(Ambiente ambiente);
}