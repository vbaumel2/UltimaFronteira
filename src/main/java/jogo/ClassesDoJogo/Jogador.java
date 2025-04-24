package jogo.ClassesDoJogo;

import jogo.Globals;

public class Jogador {
    private String nome;
    private int vida;
    private int maxVida = 100;
    private int fome;
    private int maxFome = 100;
    private int sede;
    private int maxSede = 100;
    private int sanidade;
    private final Inventario inventario;
    private int posX;
    private int posY;

    public Jogador(String nome, int vida, double capacidadeInventario, int fome, int sede) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.inventario = new Inventario(this, capacidadeInventario);
    }


    public void exibirStatus() {
        System.out.println("Status de " + nome +
                ": \n-Vida: " + vida + "/" + maxVida +
                "\n-Fome: " + fome + "/" + maxFome +
                "\n-Sede: " + sede + "/" + maxSede +
                "\n-Inventario: " + inventario.getPesoAtual() + "/" + inventario.getPesoMaximo());
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void addFome(int valorFome){

        fome = (int)  Math.min(maxFome, fome+valorFome);
        Globals.getMainWindow().getTextoFome().setText("PONTOS DE FOME: "+ fome);
    }

    public void addSede(int valorSede){

        sede = (int)  Math.min( maxSede, sede+valorSede);
        Globals.getMainWindow().getTextoSede().setText("PONTOS DE SEDE: "+ sede);
    }

    public int getPosX(){return posX; }
    public int getPosY(){return posY; }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }


    public int getFome(){
        return fome;
    }

}