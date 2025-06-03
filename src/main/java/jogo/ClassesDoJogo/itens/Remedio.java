package jogo.ClassesDoJogo.itens;

import jogo.Globals;

public class Remedio extends Item implements Usavel{
    private double valorCura;

    public void usar(){
        getInventario().getJogador().addVida(this.valorCura);
        Globals.getMainWindow().addTexto("Usando " + getNome() + ", restaurando " + valorCura + " pontos de vida.", "green");
        removeDurabilidade(1);

    }

    public Remedio(String nome, double peso, int durabilidade, int valorCura){
        super(nome, peso, durabilidade);
        this.valorCura = valorCura;
        this.getButtonActions().put("Usar", this::usar);
    }


    @Override
    public String toString(){
        return new String("Remédio: "+ getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade()+" | Valor de cura: "+ valorCura);
    }
}
