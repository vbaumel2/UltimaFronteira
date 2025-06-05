package jogo.ClassesDoJogo;

import jogo.ClassesDaInterface.janelaPrincipal.InventoryManager;
import jogo.ClassesDoJogo.itens.Arma;
import jogo.ClassesDoJogo.itens.Ferramenta;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private Jogador jogador;
    private List<Item> arrayItens;
    private double pesoMaximo;
    private double pesoAtual;
    private final InventoryManager inventoryManager;
    private final Crafter crafter;

    public Inventario(Jogador jogador, double pesoMaximo) {
        this.jogador = jogador;
        this.arrayItens = new ArrayList<>();
        this.pesoMaximo = pesoMaximo;
        this.pesoAtual = 0;
        this.inventoryManager = new InventoryManager(this);
        inventoryManager.atualizarCapacidade();
        this.crafter = new Crafter(this);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public boolean adicionarItem(Item item) {
        if (pesoAtual + item.getPeso() <= pesoMaximo) {
            item.atualizarInventario(this, this.arrayItens.size());
            arrayItens.add(item);
            pesoAtual += item.getPeso();
            System.out.println(item.getNome() + " adicionado ao inventário.");
            if(item instanceof Ferramenta){
                item.getButtonActions().put("Equipar", ()->jogador.setFerramentaEquipada((Ferramenta) item));
            } else if (item instanceof Arma) {
                item.getButtonActions().put("Equipar", ()->jogador.setArmaEquipada((Arma) item));
            }
            inventoryManager.adicionarItem(item);
            return true;
        } else {
            System.out.println("Inventário cheio! Não é possível adicionar " + item.getNome());
            Globals.getMainWindow().addTexto("Inventário cheio! Não é possível adicionar " + item.getNome(), "red");
            return false;
        }
    }

    public boolean removerItem(int pos) {
        if(arrayItens.size() > pos){
            Item itemRemovido = arrayItens.get(pos);
            pesoAtual -= itemRemovido.getPeso();
            inventoryManager.removerItem(itemRemovido);
            arrayItens.remove(pos);
            itemRemovido.atualizarInventario(null, 0);
            System.out.println("Item " + itemRemovido.getNome() + " removido do inventario!");
            for(int i = pos; i < arrayItens.size(); i++){
                arrayItens.get(i).setPosicao(i);
            }
            if(itemRemovido == jogador.getArmaEquipada()) jogador.setArmaEquipada(null);
            if(itemRemovido == jogador.getFerramentaEquipada()) jogador.setFerramentaEquipada(null);
            return true;
        }
        System.out.println("Indice do inventario invalido!");
        return false;
    }

    public void listarItens() {
        if (arrayItens.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("Itens no Inventário:");
            for(int i = 0; i< arrayItens.size(); i++){
                System.out.println((i+1)+" - " + arrayItens.get(i).getNome());
            }
        }
    }

    public List<Item> procurarItensPorNome(String nome, int quantidade){
        int n = 0;
        List<Item> retList = new ArrayList<Item>();
        for(Item item:arrayItens){
            if(item.getNome().equals(nome)){
                n++;
                retList.add(item);
                if(n>= quantidade) break;
            }
        }
        return retList;
    }

    public Item procurarPorClasse(Class<?> classe){
        for(Item item: arrayItens){
            if(classe.isInstance(item)) return item;
        }
        return null;
    }

    public void gerarCrafts(){
        crafter.craftManager.gerarCrafts();
    }

    public Item getItem(int pos){
        return arrayItens.get(pos);
    }

    public int getSize(){
        return arrayItens.size();
    }

    public double getPesoMaximo(){
        return pesoMaximo;
    }

    public double getPesoAtual(){
        return pesoAtual;
    }

    public void atualizarItem(Item item){
        inventoryManager.atualizarItem(item);
    }

}