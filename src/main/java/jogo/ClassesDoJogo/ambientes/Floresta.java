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
                Globals.Remedios.criar("Bandagem"), 0.3,
                Globals.Bebidas.criar("Agua"), 0.5,
                Globals.Alimentos.criar("Maçã"), 0.5,
                Globals.Alimentos.criar("Banana"), 0.4,
                Globals.Recursos.criar("Madeira"), 0.9,
                Globals.Recursos.criar("Graveto"), 0.4,
                Globals.Recursos.criar("Graveto"), 0.4,
                Globals.Recursos.criar("Vegetação"), 0.4,
                Globals.Recursos.criar("Vegetação densa"), 0.4
        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Chuva intensa"), 0.7,
                Globals.EventosClimaticos.criar("Armardilhas"), 0.1,
                Globals.EventosDoencas.criar("Infecção"), 0.3,
                Globals.EventosCriatura.criar("Lobo"), 0.4,
                Globals.EventosCriatura.criar("Urso"), 0.1,
                Globals.EventosExploracao.criar("Explorador morto"), 0.18

        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: forestgreen; -fx-border-color: darkgreen; -fx-border-width: 2;";
    }

    public Floresta() {
        super("Floresta", "Uma floresta densa");
    }


}