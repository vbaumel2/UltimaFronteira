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
            Globals.Alimentos.criar("Peixe"), 0.7,
            Globals.Alimentos.criar("Frutas Silvestres"), 0.2,
            Globals.Bebidas.criar("Agua"), 0.8,
                Globals.Bebidas.criar("Agua"), 0.8,
                Globals.Bebidas.criar("Agua"), 0.8,
            Globals.Bebidas.criar("Coco"), 0.3,
            Globals.Recursos.criar("Areia"), 0.5,
            Globals.Recursos.criar("Graveto"), 0.3,
                Globals.Recursos.criar("Vegetação"), 0.6
        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosCriatura.criar("Jacaré"), 0.4,
                Globals.EventosExploracao.criar("Barco abandonado"), 0.3,
                Globals.EventosClimaticos.criar("Tempestade"), 0.4
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: deepskyblue; -fx-border-color: navy; -fx-border-width: 2;";
    }

    public Lago() {
        super("Lago", "Um lago comum");
    }


}