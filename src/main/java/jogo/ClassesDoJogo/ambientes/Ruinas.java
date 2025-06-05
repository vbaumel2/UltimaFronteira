package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;
import java.util.Map;

public class Ruinas extends Ambiente {

    @Override
    public double getMinDiff(){return  0;}
    @Override
    public double getMaxDiff(){return  3;}
    @Override
    public double getPesoFome(){return 10;}
    @Override
    public double getPesoSede(){return 10;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(
            Globals.Alimentos.criar("Rações"), 0.4,
            Globals.Alimentos.criar("Mel"), 0.2,
            Globals.Bebidas.criar("Agua"), 0.5,
            Globals.Bebidas.criar("Agua grande"), 0.2,
            Globals.Remedios.criar("Bandagem"), 0.5,
            Globals.Recursos.criar("Pedra"), 0.6,
            Globals.Recursos.criar("Ferro"), 0.3,
                Globals.Ferramentas.criar("Picareta"), 0.4,
                Globals.Armas.criar("Lança"), 0.3
        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Armardilhas"), 0.6,
                Globals.EventosExploracao.criar("Local secreto"), 0.3,
                Globals.EventosExploracao.criar("Sobreviente amigavel"), 0.5,
                Globals.EventosCriatura.criar("Sobrevivente Hostil"), 0.4
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: #5a3d66;" +
                "-fx-border-color: #3a2b4c;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 3;" +
                "-fx-background-radius: 3;";
    }

    public Ruinas() {
        super("Ruinas", "Local abandonado");
    }


}
