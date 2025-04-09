package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;

public class Floresta extends Ambiente {
    public Floresta(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void explorar(Jogador jogador) {
        System.out.println("Você explora a floresta: " + getDescricao());
    }
}