package jogo.ClassesDoJogo.itens;

import java.util.Map;
import java.util.Scanner;

public class Alimento extends Item {
    private int valorFome;

    public Alimento(String nome, double peso, int durabilidade, int valorFome) {
        super(nome, peso, durabilidade);
        this.valorFome = valorFome;
    }

    public int getValorFome() {
        return valorFome;
    }

    public void consumir() {
        System.out.println("Consumindo " + getNome() + ", restaurando " + valorFome + " pontos de fome.");
        getInventario().getJogador().addFome(valorFome);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
    }

    private record Data (String nome, double peso, int durabilidade, int valorFome){};

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
    }


    @Override
    public String exibir(){
        return new String(getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade()+" | Valor de fome: "+ valorFome);
    }




}