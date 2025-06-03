package jogo.ClassesDoJogo;

import jogo.ClassesDaInterface.janelaPrincipal.CraftManager;
import jogo.ClassesDoJogo.itens.Ferramenta;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Crafter {
    final Inventario inventario;
    final CraftManager craftManager = new CraftManager(this);

    public final Map<String, Map<String, Integer>> listaFerramentas = Map.of(
            "Machado de madeira", Map.of("_q", 1, "Graveto", 3),
            "Machado de pedra", Map.of("_q", 1, "Graveto", 2, "Pedra", 2)
    );

    public final Map<String, Map<String, Integer>> listaArmas = Map.of(

    );

    public final Map<String, Map<String, Integer>> listaRecursos = Map.of(

    );

    private boolean craftItem(String nome, String nomeClasse){
        Map<String, Map<String, Integer>> listaReceitas;
        switch (nomeClasse){
            case "Ferramenta": listaReceitas = listaFerramentas; break;
            case "Arma": listaReceitas = listaArmas; break;
            case "Recurso": listaReceitas = listaRecursos; break;
            default: return false;
        }
        Map<String,Integer> receita = listaReceitas.get(nome);
        if(receita == null) return false;

        List<Item> craftItens = new ArrayList<Item>();

        for(Map.Entry<String, Integer> dupla: receita.entrySet()){
            if(dupla.getKey().equals("_q")) continue;
            String chave = dupla.getKey();
            int quantidade = dupla.getValue();
            List<Item> busca = inventario.procurarItensPorNome(chave, quantidade);
            if (busca.size() == quantidade){
                craftItens.addAll(busca);
            } else {
                return  false;
            }
        }

        for(Item item:craftItens){
            item.selfDestruir();
        }
        int q = receita.getOrDefault("_q", 1);
        for(int i = 0; i < q; i++){
            switch (nomeClasse){
                case "Ferramenta": inventario.adicionarItem(Globals.Ferramentas.criar(nome)); break;
                case "Arma": inventario.adicionarItem(Globals.Armas.criar(nome)); break;
                case "Recurso": inventario.adicionarItem(Globals.Recursos.criar(nome)); break;
                default: return false;
            }
        }

        return true;

    }

    public boolean craftFerramenta(String nome){return craftItem(nome, "Ferramenta");}
    public boolean craftArma(String nome){return craftItem(nome, "Arma");}
    public boolean craftRecurso(String nome){return craftItem(nome, "Recurso");}

    public Crafter(Inventario inventario){
        this.inventario = inventario;
    }



}
