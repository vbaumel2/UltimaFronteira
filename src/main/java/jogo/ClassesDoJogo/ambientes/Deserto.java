package jogo.ClassesDoJogo.ambientes;

public class Deserto extends Ambiente {
    public Deserto(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagir() {
        System.out.println("Você atravessa o deserto: " + getDescricao());
    }
}