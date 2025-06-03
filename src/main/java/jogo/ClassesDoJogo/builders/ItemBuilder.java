package jogo.ClassesDoJogo.builders;

import jogo.ClassesDoJogo.itens.Item;

public interface ItemBuilder {
    public abstract Item criar(String nome);
}
