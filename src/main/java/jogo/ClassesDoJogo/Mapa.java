package jogo.ClassesDoJogo;

import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.ambientes.Deserto;

public class Mapa {
    final int maxX = 9;
    final int maxY = 9;
    final private Ambiente[][] matrizAmbientes = new Ambiente[maxX][maxY];
    final private Jogador jogador;

    public Mapa(Jogador jogador){
        this.jogador = jogador;
        int xf = (int) Math.floor(((double) maxX -1)/2);
        int yf = (int) Math.floor(((double) maxY -1)/2);
        jogador.setPos(xf, yf);
        gerarMapa();
    }

    public void gerarMapa(){
        for(int i = 0; i < maxX; i++){
            for(int j = 0; j < maxY; j++){
                matrizAmbientes[i][j] = new Deserto("Deserto Normal", "Um deserto normal");
            }
        }
    }

    public void exibirMapa(){
        for(int i = 0; i < maxX; i++){
            for(int j = 0; j < maxY; j++){
                if(i == jogador.getPosX() && j == jogador.getPosY()){
                    System.out.print("(-*-) ");
                } else if(Math.abs(jogador.getPosX()-i)+Math.abs(jogador.getPosY()-j)<4) {
                    System.out.print("["+ matrizAmbientes[i][j].getNome().substring(0,3)+ "] ");
                } else System.out.print("{---} ");
            }
            System.out.print("\n");
        }
    }

    public Ambiente getAmbienteAtPos(int x, int y){
        return matrizAmbientes[x][y];
    }

    public void explorar(int x, int y){
        if(x <= maxX && 0<= x && 0 <= y && y <= maxY){
            jogador.setPos(x,y);
            matrizAmbientes[x][y].explorar(jogador);
        } else {
            System.out.println("Posição fora do mapa!");
        }
    }

}
