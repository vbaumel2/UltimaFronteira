package jogo.ClassesDoJogo.itens;

import jogo.ClassesDoJogo.Inventario;

public abstract class Item {
    protected Inventario inventario;
    protected int posicao;
    protected String nome;
    protected double peso;

    public Item(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public void atualizarInventario(Inventario inventario, int posicao){
        this.inventario = inventario;
        this.posicao = posicao;
    }

    public void atualizarPosicao(int posicao){
        this.posicao = posicao;
    }


    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return nome + " (Peso: " + peso + ")";
    }
}
