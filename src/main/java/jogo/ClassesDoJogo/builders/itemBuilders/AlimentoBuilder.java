package jogo.ClassesDoJogo.builders.itemBuilders;

import jogo.ClassesDoJogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Alimento;


public class AlimentoBuilder implements ItemBuilder {
    @Override
    public Alimento criar(String nome){
     return  switch (nome){
         case "Maçã" ->  new Alimento("Maçã", 0.2, 1, 10);
         case "Pão" -> new Alimento("Pão", 0.5, 1,15);
         case "Carne congelada" -> new Alimento("Carne congelada", 1, 1,30);
         case "Peixe" -> new Alimento("Peixe", 0.6, 1,18);
         default -> new Alimento("Vazio",0,1,0);
     };
    }
}
