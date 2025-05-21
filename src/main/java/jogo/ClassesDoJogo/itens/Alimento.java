package jogo.ClassesDoJogo.itens;

import jogo.Globals;

import java.util.Map;
import java.util.Scanner;

public class Alimento extends Item {
    private double valorFome;

    @Override
    public void usar() {
        getInventario().getJogador().addFome(valorFome);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
        Globals.getMainWindow().addTexto("Comendo " + getNome() + ", restaurando " + valorFome + " pontos de fome.", "green");
    }

    private record Data (String nome, double peso, int durabilidade, double valorFome){};

    private static Data pegarData(String nome){
        return switch (nome){
            case "Maçã" ->  new Data("Maçã", 0.2, 1, 10);
            case "Pão" -> new Data("Pão", 0.5, 1,20);
            case "Carne congelada" -> new Data("Carne congelada", 1, 1,30);
            default -> new Data("Vazio",0,1,0);
        };
    };

    public Alimento(String nome){
        super(pegarData(nome).nome(), pegarData(nome).peso(), pegarData(nome).durabilidade());
        valorFome = pegarData(nome).valorFome;
        this.getButtonActions().put("Comer", this::usar);
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