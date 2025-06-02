package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoClimatico.Tempestade;
import jogo.ClassesDoJogo.eventos.EventoCriatura.InvasaoAnimal;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Montanha extends Ambiente {

    @Override
    public double getMinDiff(){return  4;}
    @Override
    public double getMaxDiff(){return  10;}
    @Override
    public double getPesoFome(){return 5;}
    @Override
    public double getPesoSede(){return 2;}

    public Montanha(String nome, String descricao) {

        super(nome, descricao);
        List<Evento> eventos = this.getEventos();
        eventos.add(new Tempestade("Tempestade", 3));
        eventos.add(new InvasaoAnimal("Cabras da montanha ", 2));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: slategray; -fx-border-color: dimgray; -fx-border-width: 2;";
    }

}
