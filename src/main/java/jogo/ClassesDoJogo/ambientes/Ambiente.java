package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
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
    protected double difficuldade;
    private boolean visitado = false;
    private List<Item> items;
    private List<Evento> eventos;

    public abstract double getMinDiff();
    public abstract double getMaxDiff();
    public abstract double getPesoFome();
    public abstract double getPesoSede();
    public abstract List<Item> getNewItems();
    public abstract List<Evento> getNewEventos();

    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.items = new ArrayList<>();
        this.difficuldade = getMinDiff() + Math.random()*(getMaxDiff()-getMinDiff());
        this.items = getNewItems();
        this.eventos = getNewEventos();

    }

    public List<Item> getItemsFromProbability(Map<Item, Double> lista){
        List<Item> ret = new ArrayList<>();
        for(Map.Entry<Item, Double> entry: lista.entrySet()){
            if(Math.random()<= entry.getValue()) ret.add(entry.getKey());
        }
        return  ret;
    }

    public List<Evento> getEventsFromProbability(Map<Evento, Double> lista){
        List<Evento> ret = new ArrayList<>();
        for(Map.Entry<Evento, Double> entry: lista.entrySet()){
            if(Math.random()<= entry.getValue()) ret.add(entry.getKey());
        }
        return  ret;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVisitado(){return visitado;}

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void descrever(){
    }


    public void explorar(Jogador jogador, Mapa mapa){
        this.visitado = true;
        double m = 1.5;
        double s1 = mapa.getPesoSede()+getPesoSede();
        double s2 = mapa.getPesoFome()+getPesoFome();
        double danoSede = m*difficuldade*s1/(s1+s2);
        danoSede = Math.floor(10*danoSede)/10;
        double danoFome = m*difficuldade*s2/(s1+s2);
        danoFome = Math.floor(10*danoFome)/10;
        Globals.getMainWindow().addTexto("Você explora o " + nome + " - " + descricao+"\n"+
                "Aqui, você encontra "+items.size()+" itens.\n"+
                "Ao atravessar o terreno, você consome energia.\n");
        jogador.addFome(-danoFome, "Você perde "+ danoFome +" pontos de fome.");
        jogador.addSede(-danoSede, "Você perde "+ danoSede+ " pontos de sede.");
        difficuldade = Math.max(getMinDiff(), difficuldade*0.8);

        System.out.println(eventos.size());
    }

    public void addDifficuldade(double valorDiff){
        difficuldade += valorDiff;
        difficuldade = Math.max(difficuldade, getMinDiff());
    }

    public void addItems(List<Item> listaItens){
        items.addAll(listaItens);
    }

    public abstract String getAparencia();

    public List<Item> getItems() { return  items;}

    public String getDescricao() {
        return descricao;
    }

    public void addEvento(Evento evento){eventos.add(evento);}
    public boolean removeEvento(Evento evento){return eventos.remove(evento);}

    public List<Evento> getEventos(){return eventos;}

}
