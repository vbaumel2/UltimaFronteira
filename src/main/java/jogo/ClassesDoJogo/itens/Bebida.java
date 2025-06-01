package jogo.ClassesDoJogo.itens;

import jogo.Globals;

import java.util.Scanner;

public class Bebida extends Item implements  Usavel{
    private double valorSede;

    public void usar(){
        getInventario().getJogador().addSede(this.valorSede);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
        Globals.getMainWindow().addTexto("Bebendo " + getNome() + ", restaurando " + valorSede + " pontos de sede.", "green");
    }

    public Bebida(String nome, double peso, int durabilidade, double valorSede){
        super(nome, peso, durabilidade);
        this.valorSede = valorSede;
        this.getButtonActions().put("Beber", this::usar);
    }


    @Override
    public String toString(){
        return new String("Bebida: "+getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade()+" | Valor de sede: "+ valorSede);
    }

}
