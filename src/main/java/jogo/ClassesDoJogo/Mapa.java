package jogo.ClassesDoJogo;

import jogo.ClassesDoJogo.ambientes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jogo.ClassesDaInterface.janelaPrincipal.MapManager;
import jogo.ClassesDoJogo.eventos.GerenciadorEventos;
import jogo.Globals;

public class Mapa {
    private Jogador jogador;
    public final int maxX = 36;
    public final int maxY = 36;
    final private Ambiente[][] matrizAmbientes = new Ambiente[maxX][maxY];
    final private Boolean[][] ambientesVisitados = new Boolean[maxX][maxY];
    private double pesoSede = 5;
    private double pesoFome = 5;
    private  MapManager mapManager;
    public GerenciadorEventos gerenciadorEventos;
    private List<Runnable> runnables;


    public Mapa(Jogador jogador){
        this.mapManager = new MapManager(this);
        this.jogador = jogador;
        this.gerenciadorEventos = new GerenciadorEventos(this);
        runnables = new ArrayList<>();
    }

    public Jogador getJogador() {
        return jogador;
    }

    private void mudarClima(){
       double d = Math.random()-0.5;
       d = Math.max(pesoSede-3, d);
       d = Math.min(3-pesoFome, d);
       pesoFome+=d;
       pesoSede-=d;
    }

    public void centrarJogador(Jogador jogador){
        int xf = (int) Math.floor(((double) maxX -1)/2);
        int yf = (int) Math.floor(((double) maxY -1)/2);
        jogador.setPos(xf, yf);
    }

    public void gerarMapa(){
        for(int i = 0; i < maxX; i++){
            for(int j = 0; j < maxY; j++){
                Random rand = new Random();
                int a =  rand.nextInt(4);
                switch (a){
                    case 0 :{
                        matrizAmbientes[i][j] = new Deserto("Deserto Normal", "Um deserto normal");
                        break;
                    }
                    case 1 :{
                        matrizAmbientes[i][j] = new Floresta("Floresta Normal", "Uma floresta normal");
                        break;
                    }
                    case 2 :{
                        matrizAmbientes[i][j] = new Montanha("Montahna Normal", "Uma Montahna normal");
                        break;
                    }
                    case 3 :{
                        matrizAmbientes[i][j] = new Lago("Lago Normal", "Um Lago normal");
                        break;
                    }
                    default:{System.out.println("algum erro ai sla");}

                }
            }
        }

        mapManager.gerarMapa();
    }


    public void iniciarRodada(int x, int y){
        if(x < maxX && 0<= x && 0 <= y && y < maxY){
            jogador.setPos(x,y);
            Ambiente ambiente = getAmbienteAtual();
            gerenciadorEventos.tentarEventos(ambiente);
            for(Runnable r:new ArrayList<>(runnables)) r.run();
            ambiente.explorar(jogador, this);
            exibirMapa(x, y);
            mapManager.onAmbienteExplorado( matrizAmbientes[x][y]);
            mudarClima();
        } else {
            System.out.println("Posição fora do mapa!");
            Globals.getMainWindow().addTexto("Local fora do mapa!", "red");
        }
    }

    public void exibirMapa(int x, int y){
        mapManager.exibirMapa(x,y);
    }

    public Ambiente getAmbienteAtual(){
        return matrizAmbientes[jogador.getPosX()][jogador.getPosY()];
    }

    public Ambiente[][] getMatrizAmbientes(){
        return matrizAmbientes;
    }

    public void addCappedRunnable(int runLimit, Runnable task, Runnable onEnd) {
        runnables.add(new Runnable(){
            int runCount = 0;
            @Override
            public void run() {
                if (runCount < runLimit) {
                    task.run();
                    runCount++;
                    if (runCount >= runLimit) {
                        runnables.remove(this);
                        onEnd.run();
                    }
                }
            }
        });
    }

    public boolean removeRunnable(Runnable runnable){
        return runnables.remove(runnable);
    }

    public double getPesoSede(){return pesoSede;}
    public double getPesoFome(){return pesoFome;}

}
