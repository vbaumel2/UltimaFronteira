package jogo;

import jogo.ClassesDaInterface.janelaPrincipal.MainWindow;
import jogo.ClassesDoJogo.Builders.itemBuilders.*;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;

public class Globals {
    private static MainWindow mainWindow;
    public static final AlimentoBuilder Alimentos = new AlimentoBuilder();
    public static final BebidaBuilder Bebidas = new BebidaBuilder();
    public static final RemedioBuilder Remedios = new RemedioBuilder();
    public static final RecursoBuilder Recursos = new RecursoBuilder();
    public static final FerramentaBuilder Ferramentas = new FerramentaBuilder();
    public static final ArmaBuilder Armas = new ArmaBuilder();

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    public static void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
}