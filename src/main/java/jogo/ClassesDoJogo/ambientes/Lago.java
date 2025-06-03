package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;
import java.util.Map;

public class Lago extends Ambiente {

    @Override
    public double getMinDiff(){return  1;}
    @Override
    public double getMaxDiff(){return  7;}
    @Override
    public double getPesoFome(){return 6;}
    @Override
    public double getPesoSede(){return 0;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(
                Globals.Alimentos.criar("Peixe"), 0.75,
                Globals.Alimentos.criar("Peixe"), 0.75
        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Tempestade"), 0.4
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: deepskyblue; -fx-border-color: navy; -fx-border-width: 2;";
    }

    public Lago(String nome, String descricao) {
        super(nome, descricao);
    }


}