package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;

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

    @Override
    public void explorar(Jogador jogador) {
        System.out.println("Você explora o deserto: " + getDescricao());
        Random rand = new Random();

        int c = 1+rand.nextInt(3);
        jogador.addFome(-c);
        System.out.println("Você perde "+c+" pontos de fome");

        int b = 4+rand.nextInt(6);
        jogador.addSede(-b);
        System.out.println("Você perde "+b+" pontos de sede");

        int a =  rand.nextInt(6);
        Scanner scann = new Scanner(System.in);
        String ans;
        if(a<2){
            System.out.println("Você não encontra nenhum item.");
        } else if(a<4){
            System.out.println("Você encontra um pão, digite F se deseja adiciona-lo a seu inventario. Digite outra coisa caso contrario");
            ans = scann.nextLine();
            if(ans.equals("F")){
                jogador.getInventario().adicionarItem(new Alimento("Pão"));
            }

        } else {
            System.out.println("Você encontra dois pães, digite F se deseja adiciona-los a seu inventario. Digite outra coisa caso contrario");
            ans = scann.nextLine();
            if(ans.equals("F")){
                jogador.getInventario().adicionarItem(new Alimento("Pão"));
                jogador.getInventario().adicionarItem(new Alimento("Pão"));
            }
        }

    }
}