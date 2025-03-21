package jogo.ClassesDoJogo;

public class Personagem {
    private String nome;
    private int vida;
    private int fome;
    private int sede;
    private int sanidade;
    private Inventario inventario;

    public Personagem(String nome, int vida, double capacidadeInventario) {
        this.nome = nome;
        this.vida = vida;
        this.inventario = new Inventario(this, capacidadeInventario);
    }


    public void exibirStatus() {
        System.out.println("Status de " + nome + ": Vida " + vida);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void addFome(int energia){
        fome += energia;
    }

    public void addSede(int valorSede){ sede += valorSede; }
}