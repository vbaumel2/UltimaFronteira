package jogo.ClassesDoJogo.Builders.itemBuilders;

import jogo.ClassesDoJogo.Builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Alimento;
import jogo.ClassesDoJogo.itens.Ferramenta;
import jogo.ClassesDoJogo.itens.Recurso;

public class RecursoBuilder implements ItemBuilder {
    @Override
    public Recurso criar(String nome){
        return  switch (nome){
            case "Graveto" ->  new Recurso("Graveto",0.5,1,null);
            case "Madeira" -> new Recurso("Graveto",2,1,"Machado");
            case "Pedra" -> new Recurso("Pedra", 1, 1, null);
            case "Rocha" -> new Recurso("Rocha", 4, 1, "Picatera");
            default -> new Recurso("Vazio",0,1,null);
        };
    }
}
