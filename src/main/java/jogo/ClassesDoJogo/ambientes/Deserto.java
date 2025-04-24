package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.Globals;

import java.util.Random;
import java.util.Scanner;

public class Deserto extends Ambiente {
    public Deserto(String nome, String descricao) {
        super(nome, descricao);

    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: sandybrown; -fx-border-color: peru; -fx-border-width: 2;";
    }


}