package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.List;
import java.util.Map;

public class Caverna extends Ambiente {

    @Override
    public double getMinDiff(){return  4;}
    @Override
    public double getMaxDiff(){return  10;}
    @Override
    public double getPesoFome(){return 4;}
    @Override
    public double getPesoSede(){return 4;}

    @Override
    public List<Item> getNewItems(){
        return getItemsFromProbability(Map.of(
            Globals.Alimentos.criar("Cogumelo"), 0.5,
            Globals.Alimentos.criar("Raiz_comestível"), 0.3,
            Globals.Bebidas.criar("Agua"), 0.4,
            Globals.Bebidas.criar("Seiva"), 0.3,
            Globals.Recursos.criar("Pedra"), 0.7,
            Globals.Recursos.criar("Ferro"), 0.1
        ));
    }

    @Override
    public List<Evento> getNewEventos(){
        return getEventsFromProbability(Map.of(
                Globals.EventosClimaticos.criar("Deslizamento"), 0.5
        ));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: #1a1a1a;" +
                "-fx-border-color: #3b3b3b;" +
                "-fx-border-width: 2px;";
    }

    @Override
    public void explorar(Jogador jogador, Mapa mapa){
        boolean hasLight = false;
        if(jogador.getFerramentaEquipada() != null && jogador.getFerramentaEquipada().tipo.equals("lanterna")){
            hasLight = true;
            jogador.getFerramentaEquipada().usar();
        } else {
            difficuldade *= 1.75;
            Globals.getMainWindow().addTexto("Você entra na caverna sem uma luz. Será mais dificl explora-la", "grey");
        }
        super.explorar(jogador,mapa);
        if(!hasLight) difficuldade = Math.max(difficuldade/1.75, getMinDiff());

    }

    public Caverna() {
        super("Caverna", "Equipe lampadas para explorar");
    }




}