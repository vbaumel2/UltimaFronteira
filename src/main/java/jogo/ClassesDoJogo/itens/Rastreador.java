package jogo.ClassesDoJogo.itens;

import jogo.Globals;

public class Rastreador extends Item implements  Usavel{
    private int tempo = 15;

    public void usar(){
        Globals.getMainWindow().addTexto("Usando "+getNome()+", logo você será salvo!", "purple");
        this.getInventario().getJogador().getMapa().addCappedRunnable(tempo,
                ()->{
            tempo-=1;
            Globals.getMainWindow().addTexto("Em "+tempo+" rodadas você será salvo!", "Purple");
                },
                ()->{
            Globals.getMainWindow().endGame(true, "Você foi resgatado!");
                }
                );

        removeDurabilidade(1);
    }

    public Rastreador(){
        super("Rasteador", 0.5, 1);
        getButtonActions().put("Usar", this::usar);
    }


    @Override
    public String toString(){
        return "ESPECIAL: "+getNome()+"| Peso: " + getPeso() + " | Usos: "+ getDurabilidade()+ " | Use para ser salvo!";
    }
}
