package jogo.ClassesDoJogo;

import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.Globals;

public class Jogador {
    private String nome;
    private double vida;
    private double maxVida = 100;
    private double fome;
    private double maxFome = 100;
    private double sede;
    private double maxSede = 100;
    private double sanidade;
    private final Inventario inventario;
    private int posX;
    private int posY;

    public Jogador(String nome, double vida, double capacidadeInventario, double fome, double sede) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.inventario = new Inventario(this, capacidadeInventario);

    }

    private void acabarJogo(){
        System.out.println("acabando jogo!");
       Stage stage = (Stage) Globals.getMainWindow().getMainPane().getScene().getWindow();
       stage.close();
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

    public void addFome(double valorFome){

        fome =  Math.min(maxFome, fome+valorFome);
        Globals.getMainWindow().getTextoFome().setText(String.format("PONTOS DE VIDA: %.1f/%.1f",fome, maxFome));
        if(fome<=0) acabarJogo();
    }

    public void addSede(double valorSede){

        sede =  Math.min( maxSede, sede+valorSede);
        Globals.getMainWindow().getTextoSede().setText(String.format("PONTOS DE SEDE: %.1f/%.1f",sede, maxSede));
        if(sede<=0) acabarJogo();
    }

    public void addVida(double valorVida){
        vida = Math.min(maxVida, vida+valorVida);
        Globals.getMainWindow().getTextoVida().setText(String.format("PONTOS DE VIDA: %.1f/%.1f",vida, maxVida));
        if(vida<=0) acabarJogo();
    }

    public int getPosX(){return posX; }
    public int getPosY(){return posY; }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }


    public double getFome(){
        return fome;
    }

}