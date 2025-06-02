package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoClimatico.Tempestade;
import jogo.ClassesDoJogo.eventos.EventoClimatico.Terremoto;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;
import jogo.Globals;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Deserto extends Ambiente {

    @Override
    public double getMinDiff(){return  2;}
    @Override
    public double getMaxDiff(){return  6;}
    @Override
    public double getPesoFome(){return 1;}
    @Override
    public double getPesoSede(){return 4;}


    public Deserto(String nome, String descricao) {
        super(nome, descricao);
        List<Evento> eventos = this.getEventos();
        eventos.add(new Tempestade("Tempestade de areia", 4));
        eventos.add(new Terremoto("Terremoto de areia movediça", 2));

    }


    @Override
    public String getAparencia(){
        return "-fx-background-color: sandybrown; -fx-border-color: peru; -fx-border-width: 2;";
    }


}