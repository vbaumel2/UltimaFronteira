package jogo.ClassesDoJogo.itens;

public class Arma extends Item implements Usavel {
    private double dano;
    private boolean equipado = false;

    public Arma(String nome, double peso, int durabilidade, double dano){
        super(nome, peso, durabilidade);
        this.dano = dano;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    public double getDano() {
        return dano;
    }

    @Override public void usar(){
        this.removeDurabilidade(1);
    }

    public String toString(){
        return "Arma: "+getNome()+ " | Peso: " + getPeso() + " | Usos: " + getDurabilidade()+ " | Dano: "+dano;
    }
}