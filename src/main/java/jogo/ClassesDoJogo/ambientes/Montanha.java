package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;
import java.util.Map;

public class Montanha extends Ambiente {

    @Override
    public double getMinDiff(){return  4;}
    @Override
    public double getMaxDiff(){return  10;}
    @Override
    public double getPesoFome(){return 5;}
    @Override
    public double getPesoSede(){return 2;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(

        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Nevasca"), 0.8,
                Globals.EventosClimaticos.criar("Deslizamento"), 0.2
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: slategray; -fx-border-color: dimgray; -fx-border-width: 2;";
    }

    public Montanha(String nome, String descricao) {
        super(nome, descricao);
    }

}
