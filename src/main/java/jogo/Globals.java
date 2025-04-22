package jogo;

import jogo.ClassesDaInterface.janelas.MainWindow;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;

public class Globals {
    private static Jogador jogador;
    private static Mapa mapa;
    private static MainWindow mainWindow;

    public static void init(Jogador jogador, Mapa mapa, MainWindow mainWindow){
        Globals.jogador = jogador;
        Globals.mapa = mapa;
        Globals.mainWindow = mainWindow;
    }

    public static Jogador getJogador(){ return  jogador;}

    public static Mapa getMapa(){ return  mapa;}

    public static MainWindow getMainWindow(){ return  mainWindow;}
}
