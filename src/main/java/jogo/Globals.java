package jogo;

import jogo.ClassesDaInterface.janelaPrincipal.MainWindow;
import jogo.ClassesDoJogo.Builders.itemBuilders.AlimentoBuilder;
import jogo.ClassesDoJogo.Builders.itemBuilders.BebidaBuilder;
import jogo.ClassesDoJogo.Builders.itemBuilders.RemedioBuilder;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;

public class Globals {
    private static MainWindow mainWindow;
    public static final AlimentoBuilder Alimentos = new AlimentoBuilder();
    public static final BebidaBuilder Bebidas = new BebidaBuilder();
    public static final RemedioBuilder Remedios = new RemedioBuilder();

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    public static void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
}