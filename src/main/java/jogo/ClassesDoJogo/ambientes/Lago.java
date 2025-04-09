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
    public void explorar(Jogador jogador) {
        System.out.println("Você explora o lago: " + getDescricao());
        Random rand = new Random();
        int a =  rand.nextInt(6);
        Scanner scann = new Scanner(System.in);
        String ans;
        if(a<2){
            System.out.println("Você não encontra nenhum item.");
        } else if(a<4){
            System.out.println("Você encontra agua potável, digite F se deseja adiciona-la a seu inventario. Digite outra coisa caso contrario");
            ans = scann.nextLine();
            if(ans.equals("F")){
                jogador.getInventario().adicionarItem(new Bebida("Garrafa de agua"));
            }

        } else {
            System.out.println("Você encontra bastante agua potável, digite F se deseja adiciona-la a seu inventario. Digite outra coisa caso contrario");
            ans = scann.nextLine();
            if (ans.equals("F")) {
                jogador.getInventario().adicionarItem(new Bebida("Garrafa de agua"));
            }
        }
    }
}