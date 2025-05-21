package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.GerenciadorEventos;
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
    private double danoSede;
    private double danoFome;
    private boolean visitado = false;
    private GerenciadorEventos gerenciador;
    private List<Evento> eventos = new ArrayList<>();


    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.items = new ArrayList<>();
        this.gerenciador = new GerenciadorEventos(this, 0.25);

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

    public List<Evento> getEventos(){return eventos;}

    public boolean isVisitado(){return visitado;}
    public List<Item> getItems() { return  items;}

    public void descrever(){
    }

    public void explorar(Jogador jogador){
        this.visitado = true;
        Globals.getMainWindow().addTexto("Você explora o " + nome + " - " + descricao+"\n"+
                "Aqui, você encontra "+items.size()+" itens.\n"+
                "Ao atravessar o terreno, você perde:\n"+
                danoFome+" pontos de fome\n"+
                danoSede+" pontos de sede");
        jogador.addFome(-danoFome);
        jogador.addSede(-danoSede);
    }

    public abstract String getAparencia();

}
