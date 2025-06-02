package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.GerenciadorEventos;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.ClassesDoJogo.itens.Item;
import jogo.ClassesDoJogo.itens.Remedio;
import jogo.Globals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Ambiente {
    private String nome;
    private String descricao;
    private List<Item> items;
    protected double difficuldade;
    private boolean visitado = false;
    private List<Evento> eventos = new ArrayList<>();

    public abstract double getMinDiff();
    public abstract double getMaxDiff();
    public abstract double getPesoFome();
    public abstract double getPesoSede();

    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.items = new ArrayList<>();
        this.difficuldade = getMinDiff() + Math.random()*(getMaxDiff()-getMinDiff());

        Random rand = new Random();
        if(rand.nextInt(3) == 1){
            items.add(Globals.Alimentos.criar("Pão"));
        }
        if(rand.nextInt(3) == 1){
            items.add(Globals.Alimentos.criar("Maçã"));
        }
        if(rand.nextInt(3) == 1){
            items.add(Globals.Bebidas.criar("Garrafa de agua"));
        }
        if(rand.nextInt(3)  == 1){
            items.add(Globals.Bebidas.criar("Garrafa de agua grande"));
        }
        if(rand.nextInt(4) == 1){
            items.add(Globals.Remedios.criar("Bandagem"));
        }
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
        double m = 1.5;
        double danoSede = m*difficuldade*getPesoSede()/(getPesoFome()+getPesoSede());
        danoSede = Math.floor(10*danoSede)/10;
        double danoFome = m*difficuldade*getPesoFome()/(getPesoFome()+getPesoSede());
        danoFome = Math.floor(10*danoFome)/10;
        Globals.getMainWindow().addTexto("Você explora o " + nome + " - " + descricao+"\n"+
                "Aqui, você encontra "+items.size()+" itens.\n"+
                "Ao atravessar o terreno, você perde:\n"+
                danoFome+" pontos de fome\n"+
                danoSede+" pontos de sede");
        jogador.addFome(-danoFome);
        jogador.addSede(-danoSede);
        difficuldade = Math.max(getMinDiff(), difficuldade*0.8);
    }

    public abstract String getAparencia();

}
