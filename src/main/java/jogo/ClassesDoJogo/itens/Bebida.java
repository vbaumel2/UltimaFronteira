package jogo.ClassesDoJogo.itens;

public class Bebida extends Item{
    private int valorSede;

    public Bebida(String nome, double peso, int valorSede){
        super(nome, peso);
        this.valorSede = valorSede;
    }

    public void beber(){
        this.inventario.getJogador().addSede(this.valorSede);
        this.inventario.removerItem(this.posicao);
    }
}
