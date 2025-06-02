package jogo.ClassesDoJogo.itens;

public class Ferramenta extends Item {
    private boolean equipado = false;

    public Ferramenta(String nome, double peso, int durabilidade){
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
            getInventario().getJogador().setFerramentaEquipada(null);
        }
    }
}
