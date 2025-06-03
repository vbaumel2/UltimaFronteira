package jogo.ClassesDoJogo.itens;

public class Arma extends Item {
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

    public String toString(){
        return "Ferramenta: "+getNome()+ " | Peso: " + getPeso() + " | Usos: " + getDurabilidade()+ " | Dano: "+dano;
    }
}