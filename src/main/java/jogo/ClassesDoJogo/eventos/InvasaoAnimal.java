package jogo.ClassesDoJogo.eventos;

import jogo.ClassesDoJogo.ambientes.Ambiente;

public class InvasaoAnimal extends Evento {
    public InvasaoAnimal(String descricao, int impacto) {
        super(descricao, impacto);
    }

    @Override
    public void aplicarEvento(Ambiente ambiente) {
        System.out.println("Animais invadem o ambiente: " + ambiente.getNome());
    }
}