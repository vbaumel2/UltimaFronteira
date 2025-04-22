package jogo.ClassesDaInterface;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.Globals;

public class MapManager {
    final private Mapa mapa;
    final private int gridX = 7;
    final private int gridY = 7;
    final private int paneSize = 50;


    public void gerarMapa(){
        GridPane gridMap = Globals.getMainWindow().getGridMap();
        Ambiente[][] matrizAmbientes = mapa.getMatrizAmbientes();
        for (int row = 0; row < gridY; row++) {
            for (int col = 0; col < gridX; col++) {
                Pane pane = new Pane();
                pane.setPrefSize(paneSize, paneSize);
                pane.setStyle(matrizAmbientes[col][row].getAparencia());
                gridMap.add(pane, col, row);
            }
        }
    }

    public MapManager(Mapa mapa){
        this.mapa = mapa;
    }

}
