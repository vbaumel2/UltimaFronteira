package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;

public class Deserto extends Ambiente {
    public Deserto(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void explorar(Jogador jogador) {
        System.out.println("Você atravessa o deserto: " + getDescricao());
    }
}