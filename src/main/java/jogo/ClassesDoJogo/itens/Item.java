package jogo.ClassesDoJogo.itens;

import jogo.ClassesDoJogo.Inventario;

import java.util.HashMap;
import java.util.Map;

public abstract class Item {
    private Inventario inventario;
    private int posicao;
    private String nome;
    private double peso;
    private int durabilidade;
    private Map<String, Runnable> buttonActions = new HashMap<>();

    public Item(String nome, double peso, int durabilidade) {
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
        buttonActions.put("Destruir", this::selfDestruir);
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

    public Map<String, Runnable> getButtonActions(){ return  buttonActions;}

    public void removeDurabilidade(int usos){
        durabilidade -= usos;
    }

    public abstract void usar();

    @Override
    public String toString() {
        return new String(getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade());
    }
}
