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

public class Lago extends Ambiente {
    public Lago(String nome, String descricao) {
        super(nome, descricao);
        List<Evento> eventos = this.getEventos();
        eventos.add(new InvasaoAnimal("Piranhas", 5));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: deepskyblue; -fx-border-color: navy; -fx-border-width: 2;";
    }


}