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
    public double getPesoFome(){return 2;}
    @Override
    public double getPesoSede(){return 8;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(
            Globals.Alimentos.criar("Rações"), 0.3,
            Globals.Alimentos.criar("Frutas_Silvestres"), 0.2,
            Globals.Bebidas.criar("Agua"), 0.6,
            Globals.Bebidas.criar("Seiva"), 0.3,
            Globals.Recursos.criar("Areia"), 0.8
        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Tempestade_areia"), 0.6
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: sandybrown; -fx-border-color: peru; -fx-border-width: 2;";
    }

    public Deserto() {
        super("Deserto", "Um desolado deserto");
    }




}