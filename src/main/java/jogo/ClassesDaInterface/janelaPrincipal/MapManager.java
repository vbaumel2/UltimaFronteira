package jogo.ClassesDaInterface.janelaPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.Globals;

public class MapManager {
    final private Mapa mapa;
    final private int gridX = 7;
    final private int gridY = 7;
    final private int paneSize = 50;
    final private Pane[][] matrizPanes = new Pane[gridX][gridY];

    public MapManager(Mapa mapa){
        this.mapa = mapa;
    }


    public void gerarMapa(){
        int offX = (int) Math.floor(((double) gridX-1)/2);
        int offY = (int) Math.floor(((double) gridY-1)/2);

        GridPane gridMap = Globals.getMainWindow().getGridMap();
        for (int row = 0; row < gridY; row++) {
            for (int col = 0; col < gridX; col++) {
                Pane pane = new Pane();
                pane.setPrefSize(paneSize, paneSize);
                gridMap.add(pane, col, row);
                matrizPanes[col][row] = pane;

                if(row == offY && col == offX){
                    Label closeLabel = new Label("@");
                    closeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 40px;");
                    pane.getChildren().add(closeLabel);
                }
            }
        }
    }

    public void exibirMapa(int posX, int posY){
        int offX = (int) Math.floor(((double) gridX-1)/2);
        int offY = (int) Math.floor(((double) gridY-1)/2);
        Ambiente[][] matrizAmbientes = mapa.getMatrizAmbientes();
        for(int y = 0; y < gridY; y++){
            for(int x = 0; x < gridX; x++){
                int realY = y-offY+posY;
                int realX = x-offX+posX;
                if(0<= realX && realX < mapa.maxX && 0<= realY && realY < mapa.maxY){
                    matrizPanes[y][x].setStyle(matrizAmbientes[realX][realY].getAparencia());
                } else{
                    matrizPanes[y][x].setStyle("-fx-background-color: black");
                }


            }

        }



    }

    public void addTextoExploracao(String texto){
        Label line = new Label(texto);
        line.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 5;" +
                        "-fx-background-color: white;"
        );
        line.setPrefWidth(4096);
        line.setAlignment(Pos.CENTER);
        Globals.getMainWindow().getCaixaTextosExploracao().getChildren().addFirst(line);
    }

}
