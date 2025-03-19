package jogo.ClassesDoJogo.itens;


public class Alimento extends Item {
    private int energia;

    public Alimento(String nome, double peso, int energia) {
        super(nome, peso);
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public void comer() {
        System.out.println("Consumindo " + nome + ", restaurando " + energia + " pontos de fome.");
        this.inventario.getJogador().addFome(energia);
        this.inventario.removerItem(this.posicao);
    }
}