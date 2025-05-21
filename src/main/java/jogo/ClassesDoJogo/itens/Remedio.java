package jogo.ClassesDoJogo.itens;

import jogo.Globals;

public class Remedio extends Item{
    private double valorCura;

    @Override
    public void usar(){
        getInventario().getJogador().addVida(this.valorCura);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
        Globals.getMainWindow().addTexto("Usando " + getNome() + ", restaurando " + valorCura + " pontos de vida.", "green");

    }

    private record Data (String nome, double peso, int durabilidade, double valorCura){};

    private static Remedio.Data pegarData(String nome){
        return switch (nome){
            case "Bandagem" ->  new Remedio.Data("Bandagem", 0.2, 1, 10);
            default -> new Remedio.Data("Vazio",0,1,0);
        };
    };

    public Remedio(String nome){
        super(pegarData(nome).nome(), pegarData(nome).peso(), pegarData(nome).durabilidade());
        valorCura = pegarData(nome).valorCura;
        this.getButtonActions().put("Usar", this::usar);
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
