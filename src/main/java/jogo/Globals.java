package jogo;

import jogo.ClassesDaInterface.janelaPrincipal.MainWindow;
import jogo.builders.eventoBuilders.EventoClimaticoBuilder;
import jogo.builders.eventoBuilders.EventoCriaturaBuilder;
import jogo.builders.eventoBuilders.EventoDoencaFerimentoBuilder;
import jogo.builders.eventoBuilders.EventoExploracaoBuilder;
import jogo.builders.itemBuilders.*;

public class Globals {
    private static MainWindow mainWindow;
    public static final AlimentoBuilder Alimentos = new AlimentoBuilder();
    public static final BebidaBuilder Bebidas = new BebidaBuilder();
    public static final RemedioBuilder Remedios = new RemedioBuilder();
    public static final RecursoBuilder Recursos = new RecursoBuilder();
    public static final FerramentaBuilder Ferramentas = new FerramentaBuilder();
    public static final ArmaBuilder Armas = new ArmaBuilder();
    public static final EventoClimaticoBuilder EventosClimaticos = new EventoClimaticoBuilder();
    public static final EventoDoencaFerimentoBuilder EventosDoencas = new EventoDoencaFerimentoBuilder();
    public static final EventoExploracaoBuilder EventosExploracao = new EventoExploracaoBuilder();
    public static final EventoCriaturaBuilder EventosCriatura = new EventoCriaturaBuilder();

    public static MainWindow getMainWindow() {
        return mainWindow;
    }

    public static void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
}