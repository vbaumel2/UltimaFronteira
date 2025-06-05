package jogo.builders.itemBuilders;

import jogo.builders.ItemBuilder;
import jogo.ClassesDoJogo.itens.Alimento;


public class AlimentoBuilder implements ItemBuilder {
    @Override
    public Alimento criar(String nome){
     return  switch (nome){
         case "Maçã" ->  new Alimento("Maçã", 0.2, 1, 5);
         case "Banana" ->  new Alimento("Banana", 0.2, 1, 5);
         case "Carne pequena" -> new Alimento("Carne pequena", 0.7, 1,15);
         case "Carne congelada" -> new Alimento("Carne congelada", 1, 1,10);
         case "Carne grande" -> new Alimento("Carne grande", 1, 1,25);
         case "Peixe" -> new Alimento("Peixe", 0.6, 1,10);
         case "Rações" -> new Alimento("Rações", 0.5, 2, 8);
         case "Frutas Silvestres" -> new Alimento("Frutas Silvestres", 0.1, 1, 3);
         case "Cogumelo" -> new Alimento("Cogumelo", 0.12, 1, 2);
         case "Raiz comestível" -> new Alimento("Raiz comestível", 0.2, 1, 4);
         case "Nozes" -> new Alimento("Nozes", 0.08, 1, 5);
         case "Mel" -> new Alimento("Mel", 0.18, 1, 6);
         default -> new Alimento("Vazio",0,1,0);
     };
    }
}
