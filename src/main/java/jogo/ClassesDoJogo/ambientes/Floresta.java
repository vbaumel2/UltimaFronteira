package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;
import java.util.Map;

public class Floresta extends Ambiente {

    @Override
    public double getMinDiff(){return  0;}
    @Override
    public double getMaxDiff(){return  6;}
    @Override
    public double getPesoFome(){return 4;}
    @Override
    public double getPesoSede(){return 3;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(

        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Chuva intensa"), 0.7,
                Globals.EventosClimaticos.criar("Armardilhas"), 0.05
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: forestgreen; -fx-border-color: darkgreen; -fx-border-width: 2;";
    }

    public Floresta(String nome, String descricao) {
        super(nome, descricao);
    }


}