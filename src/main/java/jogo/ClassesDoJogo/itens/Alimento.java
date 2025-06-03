package jogo.ClassesDoJogo.itens;

import jogo.Globals;

import java.util.Map;
import java.util.Scanner;

public class Alimento extends Item implements Usavel{
    private double valorFome;

    public void usar() {
        getInventario().getJogador().addFome(valorFome, "Você ganha "+valorFome+" pontos de fome.");
        removeDurabilidade(1);
        Globals.getMainWindow().addTexto("Comendo " + getNome() + ", restaurando " + valorFome + " pontos de fome.", "green");
    }

    public Alimento(String nome, double peso, int durabilidade, double valorFome) {
        super(nome, peso, durabilidade);
        this.valorFome = valorFome;
        this.getButtonActions().put("Comer", this::usar);
    }

    @Override
    public String toString(){
        return new String("Alimento: "+getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade()+" | Valor de fome: "+ valorFome);
    }

}