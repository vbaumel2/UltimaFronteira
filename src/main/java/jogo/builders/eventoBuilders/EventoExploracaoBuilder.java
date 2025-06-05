package jogo.builders.eventoBuilders;

import jogo.builders.EventoBuilder;
import jogo.ClassesDoJogo.eventos.Evento;
import jogo.ClassesDoJogo.eventos.EventoDescoberta;
import jogo.ClassesDoJogo.itens.Antidoto;
import jogo.Globals;

import java.util.List;

public class EventoExploracaoBuilder implements EventoBuilder {

    public Evento criar(String nome){
        return switch (nome){
            case "Explorador morto" -> new EventoDescoberta("Explorador morto", 3, List.of(
                    Globals.Bebidas.criar("Agua grande"),
                    Globals.Alimentos.criar("Rações"),
                    Globals.Ferramentas.criar("Lanterna"),
                    Globals.Armas.criar("Faca"),
                    Globals.Remedios.criar("Bandagem"),
                    new Antidoto()
            ));
            case "Local secreto" -> new EventoDescoberta("Local secreto", 2, List.of(
               new Antidoto(),
               Globals.Alimentos.criar("Rações"),
                    Globals.Alimentos.criar("Mel"),
                    Globals.Bebidas.criar("Agua grande"),
                    Globals.Ferramentas.criar("Lanterna"),
                    Globals.Armas.criar("Arco")

            ));
            case "Barco abandonado" -> new EventoDescoberta("Barco abandonado", 4, List.of(
                    new Antidoto(),
                    Globals.Alimentos.criar("Rações"),
                    Globals.Alimentos.criar("Rações"),
                    Globals.Bebidas.criar("Coco"),
                    Globals.Bebidas.criar("Coco"),
                    Globals.Remedios.criar("Ervas medicinais"),
                    Globals.Ferramentas.criar("Pá"),
                    Globals.Armas.criar("Lança")
            ));
            case "Sobreviente amigavel" -> new EventoDescoberta("Sobreviente amigavel", 6, List.of(
                    new Antidoto(),
                    Globals.Alimentos.criar("Carne pequena"),
                    Globals.Alimentos.criar("Peixe"),
                    Globals.Bebidas.criar("Agua grande"),
                    Globals.Remedios.criar("Folhas cicatrizantes"),
                    Globals.Armas.criar("Espada")
            ));


            default -> new EventoDescoberta("Nada", 1, List.of());
        };
    }
}