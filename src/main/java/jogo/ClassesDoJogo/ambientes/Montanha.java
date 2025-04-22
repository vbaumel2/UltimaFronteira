package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;

import java.util.Random;
import java.util.Scanner;

public class Montanha extends Ambiente {
    public Montanha(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: slategray; -fx-border-color: dimgray; -fx-border-width: 2;";
    }

    @Override
    public void explorar(Jogador jogador) {
        System.out.println("Você explora a montanha: " + getDescricao());
        Random rand = new Random();

        int c = 4+rand.nextInt(7);
        jogador.addFome(-c);
        System.out.println("Você perde "+c+" pontos de fome");

        int b = 4+rand.nextInt(7);
        jogador.addSede(-b);
        System.out.println("Você perde "+b+" pontos de sede");

        int a =  rand.nextInt(6);
        Scanner scann = new Scanner(System.in);
        String ans;
        if(a<2){
            System.out.println("Você não encontra nenhum item.");
        } else if(a<4) {
            System.out.println("Você encontra agua potável, digite F se deseja adiciona-la a seu inventario. Digite outra coisa caso contrario");
            ans = scann.nextLine();
            if (ans.equals("F")) {
                jogador.getInventario().adicionarItem(new Bebida("Garrafa de agua"));
            }
        } else {
            System.out.println("Você encontra carne congelada, digite F se deseja adiciona-la a seu inventario. Digite outra coisa caso contrario");
            ans = scann.nextLine();
            if (ans.equals("F")) {
                jogador.getInventario().adicionarItem(new Alimento("Carne congelada"));
            }
        }

    }
}
