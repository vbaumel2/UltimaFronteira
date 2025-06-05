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
            "Machado improvisado", Map.of("_q", 1, "Graveto", 2, "Pedra", 2, "Vegetação", 1),
            "Machado", Map.of("_q", 1, "Graveto", 2, "Ferro", 1, "Vegetação", 1),

            "Pá improvisada", Map.of("_q", 1, "Graveto", 2, "Pedra", 2, "Vegetação", 1),
            "Pá", Map.of("_q", 1, "Graveto", 2, "Ferro", 1, "Vegetação", 1),

            "Picareta improvisada", Map.of("_q", 1, "Graveto", 2, "Pedra", 2, "Vegetação", 1),
            "Picareta", Map.of("_q", 1, "Graveto", 2, "Ferro", 1, "Vegetação", 1),

            "Tocha", Map.of("_q", 1, "Graveto", 2, "Carvão", 1)
    );

    public final Map<String, Map<String, Integer>> listaArmas = Map.of(
            "Faca Improvisada", Map.of("_q", 1, "Graveto", 1, "Pedra", 1, "Vegetação", 1),
            "Faca", Map.of("_q", 1, "Graveto", 1, "Ferro", 1, "Vegetação", 1),

            "Graveto afiado", Map.of("_q",1, "Graveto", 2),

            "Espada Improvisada", Map.of("_q", 1, "Graveto", 2, "Pedra", 2, "Vegetação", 1),
            "Espada", Map.of("_q", 1, "Graveto", 2, "Ferro", 1, "Vegetação", 1),

            "Lança Improvisada", Map.of("_q", 1, "Graveto", 2, "Pedra", 2, "Vegetação", 1),
            "Lança", Map.of("_q", 1, "Graveto", 2, "Ferro", 1, "Vegetação", 1),

            "Arco Improvisado", Map.of("_q", 1, "Graveto", 1, "Pedra", 1, "Vegetação", 2),
            "Arco", Map.of("_q", 1, "Graveto", 1, "Ferro", 1, "Vegetação", 2)

    );

    public final Map<String, Map<String, Integer>> listaRecursos = Map.of(
            "Graveto" , Map.of("_q",4, "Madeira", 1),
            "Pedra" , Map.of("_q",4, "Rocha", 1),
            "Vegetação" , Map.of("_q",3, "Vegetação densa", 1)
    );

    public boolean craftItem(String nome, String nomeClasse, Map<String,Integer> receita){
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
                case "Material": inventario.adicionarItem(Globals.Recursos.criar(nome)); break;
                default: return false;
            }
        }

        return true;

    }

    public boolean craftFerramenta(String nome){return craftItem(nome, "Ferramenta", listaFerramentas.get(nome));}
    public boolean craftArma(String nome){return craftItem(nome, "Arma", listaArmas.get(nome));}
    public boolean craftRecurso(String nome){return craftItem(nome, "Material", listaRecursos.get(nome));}

    public Crafter(Inventario inventario){
        this.inventario = inventario;
    }



}
