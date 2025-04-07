package jogo.ClassesDoJogo.ambientes;

public class Montanha extends Ambiente {
    public Montanha(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagir() {
        System.out.println("Você escala a montanha: " + getDescricao());
    }
}
