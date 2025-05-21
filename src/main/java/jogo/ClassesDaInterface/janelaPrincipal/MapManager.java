package jogo.ClassesDaInterface.janelaPrincipal;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.HashMap;
import java.util.Map;

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

    public void explorar(Ambiente ambiente){

        VBox caixaItens = Globals.getMainWindow().getCaixaAmbienteItens();
        caixaItens.getChildren().clear();
        for(Item item: ambiente.getItems()){
            Button line = new Button();
            line.setPrefWidth(4096);
            line.setPrefHeight(30);
            line.setAlignment(Pos.CENTER);
            line.setText(item.toString());
            line.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 5;" +
                            "-fx-background-color: white;"
            );
            caixaItens.getChildren().add(line);
            Map<String, Runnable> actions = new HashMap<>();
            actions.put("Coletar", ()->{
                caixaItens.getChildren().remove(line);
                ambiente.getItems().remove(item);
                Globals.getJogador().getInventario().adicionarItem(item);
            });
            line.setOnMouseClicked(event -> {
                Globals.getMainWindow().makeOptionsPopup(actions, event);
            });
        }
    }

}
