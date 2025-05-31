package jogo.ClassesDoJogo;

import jogo.ClassesDoJogo.ambientes.*;

import java.util.Random;

import jogo.ClassesDaInterface.janelaPrincipal.MapManager;
import jogo.ClassesDoJogo.eventos.GerenciadorEventos;
import jogo.Globals;

public class Mapa {
    private Jogador jogador;
    public final int maxX = 9;
    public final int maxY = 9;
    final private Ambiente[][] matrizAmbientes = new Ambiente[maxX][maxY];
    final private Boolean[][] ambientesVisitados = new Boolean[maxX][maxY];
    private double visao = 3;
    private  MapManager mapManager;
    public GerenciadorEventos gerenciadorEventos;


    public Mapa(Jogador jogador){
        this.mapManager = new MapManager(this);
        this.jogador = jogador;
        this.gerenciadorEventos = new GerenciadorEventos(this, 0.25);
    }

    public Jogador getJogador() {
        return jogador;
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


    public Ambiente getAmbienteAtPos(int x, int y){
        return matrizAmbientes[x][y];
    }

    public Ambiente[][] getMatrizAmbientes(){
        return matrizAmbientes;
    }

    public void iniciarRodada(int x, int y){
        if(x < maxX && 0<= x && 0 <= y && y < maxY){
            jogador.setPos(x,y);
            matrizAmbientes[x][y].explorar(jogador);
            exibirMapa(x, y);
            mapManager.onAmbienteExplorado( matrizAmbientes[x][y]);
            gerenciadorEventos.tentarEventos( matrizAmbientes[x][y]);
        } else {
            System.out.println("Posição fora do mapa!");
            Globals.getMainWindow().addTexto("Local fora do mapa!", "red");
        }
    }

    public void exibirMapa(int x, int y){
        mapManager.exibirMapa(x,y);
    }

}
