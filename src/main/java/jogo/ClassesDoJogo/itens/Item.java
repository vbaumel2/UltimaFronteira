package jogo.ClassesDoJogo.itens;

import jogo.ClassesDoJogo.Inventario;

public abstract class Item {
    private Inventario inventario;
    private int posicao;
    private String nome;
    private double peso;
    private int durabilidade;

    public Item(String nome, double peso, int durabilidade) {
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    public void atualizarInventario(Inventario inventario, int posicao){
        this.inventario = inventario;
        this.posicao = posicao;
    }

    public void selfDestruir(){
        getInventario().removerItem(posicao);
    }

    public void setPosicao(int posicao){
        this.posicao = posicao;
    }

    public Inventario getInventario() {return inventario; }

    public int getPosicao() {return posicao; }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public int getDurabilidade() {return durabilidade; }

    public void removeDurabilidade(int usos){
        durabilidade -= usos;
    }

    public abstract String exibir();

    @Override
    public String toString() {
        return nome + " (Peso: " + peso + ")";
    }
}
