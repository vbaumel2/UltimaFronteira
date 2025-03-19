package jogo.ClassesDoJogo;

import jogo.ClassesDoJogo.itens.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private Jogador jogador;
    private List<Item> itens;
    private double pesoMaximo;
    private double pesoAtual;

    public Inventario(Jogador jogador, double pesoMaximo) {
        this.jogador = jogador;
        this.itens = new ArrayList<>();
        this.pesoMaximo = pesoMaximo;
        this.pesoAtual = 0;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public boolean adicionarItem(Item item) {
        if (pesoAtual + item.getPeso() <= pesoMaximo) {
            item.atualizarInventario(this, this.itens.size());
            itens.add(item);
            pesoAtual += item.getPeso();
            System.out.println(item.getNome() + " adicionado ao inventário.");
            return true;
        } else {
            System.out.println("Inventário cheio! Não é possível adicionar " + item.getNome());
            return false;
        }
    }

    public boolean removerItem(int pos) {
        if(itens.size() > pos){
            Item itemRemovido = itens.get(pos);
            pesoAtual -= itemRemovido.getPeso();
            itens.remove(pos);
            itemRemovido.atualizarInventario(null, 0);
            System.out.println("Item " + itemRemovido.getNome() + " removido do inventario!");
            for(int i = pos; i < itens.size(); i++){
                itens.get(i).atualizarPosicao(i);
            }
            return true;
        }
        System.out.println("Indice do inventario invalido!");
        return false;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("Itens no Inventário:");
            for (Item item : itens) {
                System.out.println("- " + item);
            }
        }
    }
}