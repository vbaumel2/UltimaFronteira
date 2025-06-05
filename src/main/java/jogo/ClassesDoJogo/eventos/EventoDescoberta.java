package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.ArrayList;
import java.util.List;

public class EventoDescoberta extends  Evento {
    private List<Item> items;

    public EventoDescoberta(String nome, double peso, List<Item> items){
        super(nome, peso);
        this.items = items;
    }

    @Override
    public void aplicarEvento(Jogador jogador, Mapa mapa){
        Ambiente ambiente = getAmbiente();
        Globals.getMainWindow().addTexto("Você encontra "+getNome()+" no ambiente. Lá,\n"+
        "você encontra"+items.size()+" itens adicionais.", "orange");
        ambiente.addItems(items);
        ambiente.removeEvento(this);
    }
}
