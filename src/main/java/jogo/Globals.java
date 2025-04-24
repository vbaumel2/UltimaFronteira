package jogo;

import jogo.ClassesDaInterface.janelaPrincipal.MainWindow;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;

public class Globals {
    private static Jogador jogador;
    private static Mapa mapa;
    private static MainWindow mainWindow;

    // Getters
    public static Jogador getJogador() {
        return jogador;
    }

    public static Mapa getMapa() {
        return mapa;
    }

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    // Setters
    public static void setJogador(Jogador j) {
        jogador = j;
    }

    public static void setMapa(Mapa m) {
        mapa = m;
    }

    public static void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
}