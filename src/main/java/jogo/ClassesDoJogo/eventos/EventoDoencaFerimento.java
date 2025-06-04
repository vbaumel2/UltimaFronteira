package jogo.ClassesDoJogo.eventos;

import javafx.scene.control.Button;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.itens.Antidoto;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

public class EventoDoencaFerimento extends Evento {
    private int duracao;
    private double dano;
    private Button button;

    public EventoDoencaFerimento(String nome, double peso, int duracao ,double dano) {
        super(nome, peso);
        this.duracao = duracao;
        this.dano = dano;
    }

    public void aplicarEvento(Jogador jogador, Mapa mapa){
        Ambiente ambiente = getAmbiente();
        ambiente.removeEvento(this);
        Globals.getMainWindow().addTexto("Você está com "+getNome()+". Você perderá \n"+
                dano+" pontos de vida por "+duracao+" rodadas \n"+
                "a não ser que use um antidoto.", "orange");


        Runnable task = ()->{
            duracao-=1;
            button.setText("Curar "+getNome()+" | Rodadas restantes: "+ duracao + " | Requer antidoto.");
            Globals.getMainWindow().addTexto(getNome()+ " continua a afetar você.");
            if(dano>0) jogador.addVida(-dano, "Você perde "+ dano + " pontos de vida devido a "+ getNome());
        };

         button = Globals.getMainWindow().addAcao("", ()->{
            Item anti = jogador.getInventario().procurarPorClasse(Antidoto.class);
            if(anti != null){
                mapa.removeRunnable(task);
                Globals.getMainWindow().addTexto("Fim de "+getNome());
                ambiente.addEvento(this);
                Globals.getMainWindow().getCaixaAcoes().getChildren().remove(button);
                button = null;
            }
        });

        Runnable onEnd = ()->{
            Globals.getMainWindow().addTexto("Fim de "+getNome());
            ambiente.addEvento(this);
            Globals.getMainWindow().getCaixaAcoes().getChildren().remove(button);
        };


        mapa.addCappedRunnable(duracao, task, onEnd);
    };

}
