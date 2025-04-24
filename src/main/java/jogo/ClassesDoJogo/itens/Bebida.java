package jogo.ClassesDoJogo.itens;

import java.util.Scanner;

public class Bebida extends Item{
    private int valorSede;

    public Bebida(String nome, double peso, int durabilidade, int valorSede){
        super(nome, peso, durabilidade);
        this.valorSede = valorSede;
    }

    public void beber(){
        getInventario().getJogador().addSede(this.valorSede);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
        System.out.println("Consumindo " + getNome() + ", restaurando " + valorSede + " pontos de sede.");
    }

    private record Data (String nome, double peso, int durabilidade, int valorSede){};

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
    }

    public void verStatus(){
        System.out.println(getNome());
        System.out.println("-Peso: "+getPeso());
        System.out.println("-Durabilidade: "+getDurabilidade());
        System.out.println("-Valor de sede: "+valorSede);
    }

    @Override
    public String exibir(){
        return new String(getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade()+" | Valor de sede: "+ valorSede);
    }

}
