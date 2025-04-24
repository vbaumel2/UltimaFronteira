package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Ambiente {
    private String nome;
    private String descricao;
    private List<Item> items;
    private int danoSede;
    private int danoFome;

    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.items = new ArrayList<>();

        Random rand = new Random();
        if(rand.nextInt(3) == 1){
            items.add(new Alimento("Pão"));
        }
        if(rand.nextInt(3) == 1){
            items.add(new Alimento("Maçã"));
        }
        if(rand.nextInt(3) == 1){
            items.add(new Bebida("Garrafa de agua"));
        }
        if(rand.nextInt(3)  == 1){
            items.add(new Bebida("Garrafa de agua grande"));
        }

        this.danoFome = 1+ rand.nextInt(7);
        this.danoSede = 1+ rand.nextInt( 7);



    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Item> getItems() { return  items;}

    public void descrever(){
        Globals.getMapa().addTextoExploracao("Você explora o " + nome + " - " + descricao);
        Globals.getMapa().addTextoExploracao("Aqui, você encontra "+items.size()+" itens.");
    }

    public void explorar(Jogador jogador){
        descrever();
        Globals.getMapa().addTextoExploracao("Ao atravessar o terreno, você perde:");
        Globals.getMapa().addTextoExploracao(danoFome+" pontos de fome");
        jogador.addFome(-danoFome);
        Globals.getMapa().addTextoExploracao(danoSede+" pontos de sede");
        jogador.addSede(-danoSede);
    }

    public abstract String getAparencia();

}
