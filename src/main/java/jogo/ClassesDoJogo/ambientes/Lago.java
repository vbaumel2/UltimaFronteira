package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;

import java.util.Random;
import java.util.Scanner;

public class Lago extends Ambiente {
    public Lago(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: deepskyblue; -fx-border-color: navy; -fx-border-width: 2;";
    }


}