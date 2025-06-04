package jogo.ClassesDoJogo.itens;

import jogo.Globals;

public class Antidoto extends Item implements  Usavel{

    public void usar(){
        Globals.getMainWindow().addTexto("Usando "+getNome(), "green");
        removeDurabilidade(1);
    }

    public Antidoto(){
        super("Antidoto", 0.3, 1);
        this.getButtonActions().put("Usar", this::usar);
    }


    @Override
    public String toString(){
        return new String("Antidoto: "+ getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade());
    }
}
