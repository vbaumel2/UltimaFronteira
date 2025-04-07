package jogo.ClassesDoJogo.ambientes;

public class Floresta extends Ambiente {
    public Floresta(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void interagir() {
        System.out.println("Você explora a floresta: " + getDescricao());
    }
}