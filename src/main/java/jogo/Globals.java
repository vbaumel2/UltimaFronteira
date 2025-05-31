package jogo;

import jogo.ClassesDaInterface.janelaPrincipal.MainWindow;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;

public class Globals {
    private static MainWindow mainWindow;

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    public static void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
}