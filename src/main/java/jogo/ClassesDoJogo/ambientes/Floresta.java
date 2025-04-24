package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;

import java.util.Random;
import java.util.Scanner;

public class Floresta extends Ambiente {
    public Floresta(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: forestgreen; -fx-border-color: darkgreen; -fx-border-width: 2;";
    }

}