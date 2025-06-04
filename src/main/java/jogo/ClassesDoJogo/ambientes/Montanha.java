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
            Globals.Alimentos.criar("Nozes"), 0.3,
            Globals.Alimentos.criar("Carne_congelada"), 0.2,
            Globals.Bebidas.criar("Agua"), 0.5,
            Globals.Bebidas.criar("Agua_grande"), 0.2,
            Globals.Recursos.criar("Pedra"), 0.7,
            Globals.Recursos.criar("Ferro"), 0.3
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

    public Montanha() {
        super("Montanha", "Uma grande montaha");
    }

}
