package jogo.ClassesDoJogo;

public class Jogador {
    private String nome;
    private int vida;
    private int fome;
    private int sede;
    private int sanidade;
    private final Inventario inventario;
    private int posX;
    private int posY;
    private final Mapa mapa = new Mapa(this);

    public Jogador(String nome, int vida, double capacidadeInventario, int fome, int sede) {
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

    public int getPosX(){return posX; }
    public int getPosY(){return posY; }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public Mapa getMapa(){return mapa;}

}