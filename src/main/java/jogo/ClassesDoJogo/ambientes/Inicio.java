package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.itens.Antidoto;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inicio extends Ambiente {
    public Inicio() {
        super("Inicio", "Ponto inicial da aventura");
        setVisitado(true);
    }

    @Override
    public double getMinDiff() { return 1; }
    @Override
    public double getMaxDiff() { return 1; }
    @Override
    public double getPesoFome() { return 6; }
    @Override
    public double getPesoSede() { return 6; }

    @Override
    public List<Item> getNewItems() {
        return new ArrayList<>(List.of(
                Globals.Alimentos.criar("Maçã"),
                Globals.Alimentos.criar("Frutas_Silvestres"),
                Globals.Bebidas.criar("Agua"),
                Globals.Bebidas.criar("Coco"),
                Globals.Armas.criar("Faca"),
                Globals.Ferramentas.criar("Machado_madeira"),
                Globals.Remedios.criar("Bandagem"),
                new Antidoto()
        ));
    }

    @Override
    public List<Evento> getNewEventos() {
        return Collections.emptyList();
    }

    @Override
    public String getAparencia() {
        return "-fx-background-color: #e0e0e0; -fx-border-color: #888; -fx-border-width: 2px;";
    }

    @Override
    public void explorar(Jogador jogador, Mapa mapa) {
        super.explorar(jogador, mapa);
    }
}
