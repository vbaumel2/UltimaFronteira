package jogo.ClassesDoJogo.itens;

public class Arma extends Item {
    private boolean equipado = false;

    public Arma(String nome, double peso, int durabilidade){
        super(nome, peso, durabilidade);
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    @Override
    public void selfDestruir(){
        super.selfDestruir();
        if(equipado){
            getInventario().getJogador().setArmaEquipada(null);
        }
    }
}