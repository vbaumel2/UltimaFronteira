package jogo.ClassesDoJogo.itens;

import jogo.Globals;

import java.util.Scanner;

public class Bebida extends Item{
    private double valorSede;

    @Override
    public void usar(){
        getInventario().getJogador().addSede(this.valorSede);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
        Globals.getMainWindow().addTexto("Bebendo " + getNome() + ", restaurando " + valorSede + " pontos de sede.", "green");
    }

    private record Data (String nome, double peso, int durabilidade, double valorSede){};

    private static Data pegarData(String nome){
        return switch (nome){
            case "Garrafa de agua" ->  new Data("Garrafa", 0.2, 1, 10);
            case "Garrafa de agua grande" -> new Data("Garrafa grande", 0.5, 1,20);
            default -> new Data("Vazio",0,1,0);
        };
    };

    public Bebida(String nome){
        super(pegarData(nome).nome(), pegarData(nome).peso(), pegarData(nome).durabilidade());
        valorSede = pegarData(nome).valorSede;
        this.getButtonActions().put("Beber", this::usar);
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
