package jogo.ClassesDoJogo.ambientes;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoClimatico.Tempestade;
import jogo.ClassesDoJogo.eventos.EventoClimatico.Terremoto;
import jogo.ClassesDoJogo.eventos.EventoCriatura.InvasaoAnimal;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Bebida;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Floresta extends Ambiente {
    public Floresta(String nome, String descricao) {
        super(nome, descricao);
        List<Evento> eventos = this.getEventos();
        eventos.add(new Tempestade("Tempestade de chuva", 3));
        eventos.add(new InvasaoAnimal("Animais da floresta", 2));
        eventos.add(new Terremoto("Terremoto", 1));
    }

    @Override
    public String getAparencia(){
        return "-fx-background-color: forestgreen; -fx-border-color: darkgreen; -fx-border-width: 2;";
    }

}