package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;

public abstract class Ambiente {
    private String nome;
    private String descricao;

    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void explorar(Jogador jogador);
}
