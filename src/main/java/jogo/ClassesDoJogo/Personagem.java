package jogo.ClassesDoJogo;

public class Personagem {
    private String nome;
    private int vida;
    private int fome;
    private int sede;
    private int sanidade;
    private Inventario inventario;

    public Personagem(String nome, int vida, double capacidadeInventario, int fome, int sede) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.inventario = new Inventario(this, capacidadeInventario);
    }


    public void exibirStatus() {
        System.out.println("Status de " + nome +
                ": \n Vida:" + vida +
                "\n Fome: " + fome+
                "\n Sede: " + sede);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void addFome(int energia){
        fome += energia;
    }

    public void addSede(int valorSede){ sede += valorSede; }
}