package jogo.ClassesDoJogo.itens;

public class Ferramenta extends Item implements Usavel {
    public final String tipo;
    private boolean equipado = false;

    public Ferramenta(String nome, double peso, int durabilidade, String tipo){
        super(nome, peso, durabilidade);
        this.tipo = tipo;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    public void usar(){

    }

    @Override
    public String toString(){
        return "Ferramenta: "+getNome()+ " | Peso: " + getPeso() + " | Usos: " + getDurabilidade()+ " | Tipo: "+tipo;
    }
}
