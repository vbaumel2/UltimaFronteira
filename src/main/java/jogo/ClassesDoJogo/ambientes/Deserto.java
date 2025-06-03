package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;
import java.util.Map;

public class Deserto extends Ambiente {

    @Override
    public double getMinDiff(){return  2;}
    @Override
    public double getMaxDiff(){return  6;}
    @Override
    public double getPesoFome(){return 1;}
    @Override
    public double getPesoSede(){return 4;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(

        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Tempestade de areia"), 0.6
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: sandybrown; -fx-border-color: peru; -fx-border-width: 2;";
    }

    public Deserto(String nome, String descricao) {
        super(nome, descricao);
    }




}