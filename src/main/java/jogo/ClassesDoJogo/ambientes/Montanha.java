package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;

public class Montanha extends Ambiente {
    public Montanha(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void explorar(Jogador jogador) {

        System.out.println("Você escala a montanha: " + getDescricao());
    }
}
