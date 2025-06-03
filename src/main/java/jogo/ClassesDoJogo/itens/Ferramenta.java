package jogo.ClassesDoJogo.itens;

import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;

public class Ferramenta extends Item implements Usavel {
    public final String tipo;
    private boolean equipado = false;
    private double eficiencia;

    public Ferramenta(String nome, double peso, int durabilidade, String tipo, double eficiencia){
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    public boolean isEquipado() {
        return equipado;
    }

    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }

    @Override
    public void usar(){
        Jogador jogador = getInventario().getJogador();
        jogador.addFome(5/eficiencia);
        jogador.addSede(5/eficiencia);

        this.removeDurabilidade(1);
    }

    @Override
    public String toString(){
        return "Ferramenta: "+getNome()+ " | Peso: " + getPeso() + " | Usos: " + getDurabilidade()+ " | Tipo: "+tipo+ "| Eficiência: "+eficiencia;
    }
}
