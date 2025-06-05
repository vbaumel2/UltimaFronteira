package jogo.ClassesDoJogo;

import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.ClassesDoJogo.itens.Arma;
import jogo.ClassesDoJogo.itens.Ferramenta;
import jogo.Globals;

public class Jogador {
    private String nome;
    private double vida;
    private double maxVida;
    private double fome;
    private double maxFome;
    private double sede;
    private double maxSede;
    private double visao;
    private int posX;
    private int posY;

    private double multiplicadorSobrevivencia;

    private final Inventario inventario;

    private Ferramenta ferramentaEquipada;
    private Arma armaEquipada;

    public Jogador(String nome, double vida, double capacidadeInventario, double fome, double sede, double multiplicadorSobrevivencia, double visao) {
        this.nome = nome;
        this.vida = vida;
        this.maxVida = vida;
        this.fome = fome;
        this.maxFome = fome;
        this.sede = sede;
        this.maxSede = sede;
        this.inventario = new Inventario(this, capacidadeInventario);
        this.multiplicadorSobrevivencia = multiplicadorSobrevivencia;
        this.visao = visao;

        Globals.getMainWindow().getTextoFome().setText(String.format("PONTOS DE FOME: %.1f/%.1f",fome, maxFome));
        Globals.getMainWindow().getTextoSede().setText(String.format("PONTOS DE SEDE: %.1f/%.1f",sede, maxSede));
        Globals.getMainWindow().getTextoVida().setText(String.format("PONTOS DE VIDA: %.1f/%.1f",vida, maxVida));
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

    public void addFome(double valorFome){
        if(valorFome < 0) valorFome*= multiplicadorSobrevivencia;
        fome =  Math.min(maxFome, fome+valorFome);
        Globals.getMainWindow().getTextoFome().setText(String.format("PONTOS DE FOME: %.1f/%.1f",fome, maxFome));
        if(fome<=0) acabarJogo();
    }

    public void addFome(double valor, String mensagem){
        addFome(valor);
        String color = "green";
        if(valor <0) color = "red";
        Globals.getMainWindow().addTexto(mensagem, color);
    }


    public void addSede(double valorSede){
        if(valorSede < 0) valorSede*= multiplicadorSobrevivencia;
        sede =  Math.min( maxSede, sede+valorSede);
        Globals.getMainWindow().getTextoSede().setText(String.format("PONTOS DE SEDE: %.1f/%.1f",sede, maxSede));
        if(sede<=0) acabarJogo();
    }

    public void addSede(double valor, String mensagem){
        addSede(valor);
        String color = "green";
        if(valor <0) color = "red";
        Globals.getMainWindow().addTexto(mensagem, color);
    }

    public void addVida(double valorVida){
        vida = Math.min(maxVida, vida+valorVida);
        Globals.getMainWindow().getTextoVida().setText(String.format("PONTOS DE VIDA: %.1f/%.1f",vida, maxVida));
        if(vida<=0) acabarJogo();
    }

    public void addVida(double valor, String mensagem){
        addVida(valor);
        String color = "green";
        if(valor <0) color = "red";
        Globals.getMainWindow().addTexto(mensagem, color);
    }

    public int getPosX(){return posX; }
    public int getPosY(){return posY; }

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void setFerramentaEquipada(Ferramenta ferramenta){
        if(ferramentaEquipada!=null) ferramentaEquipada.setEquipado(false);
        ferramentaEquipada = ferramenta;
        if(ferramentaEquipada != null){
            ferramentaEquipada.setEquipado(true);
            Globals.getMainWindow().getTextoFerramenta().setText("FERRAMENTA EQUIPADA: "+ferramenta.getNome());
        } else {
            Globals.getMainWindow().getTextoFerramenta().setText("FERRAMENTA EQUIPADA:");
        }
    }

    public void setArmaEquipada(Arma arma){
        if(armaEquipada!=null) armaEquipada.setEquipado(false);
        armaEquipada = arma;
        if(arma != null){
            arma.setEquipado(true);
            Globals.getMainWindow().getTextoArma().setText("ARMA EQUIPADA: "+arma.getNome());
        } else Globals.getMainWindow().getTextoArma().setText("ARMA EQUIPADA:");
    }

    public double getFome(){
        return fome;
    }

    public double getVisao() { return visao;}

    public Inventario getInventario() {
        return inventario;
    }

    public Ferramenta getFerramentaEquipada() {return  ferramentaEquipada;}

    public Arma getArmaEquipada() {return  armaEquipada;}
}