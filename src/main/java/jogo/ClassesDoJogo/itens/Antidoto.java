package jogo.ClassesDoJogo.itens;

import jogo.Globals;

public class Antidoto extends Item implements  Usavel{

    public void usar(){
        Globals.getMainWindow().addTexto("Usando "+getNome(), "green");
        removeDurabilidade(1);
    }

    public Antidoto(String nome, double peso, int durabilidade, int valorCura){
        super(nome, peso, durabilidade);
        this.getButtonActions().put("Usar", this::usar);
    }


    @Override
    public String toString(){
        return new String("Antidoto: "+ getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade());
    }
}
