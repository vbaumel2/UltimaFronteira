package jogo.ClassesDaInterface.janelaPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.ambientes.Ambiente;
import jogo.ClassesDoJogo.itens.Item;
import jogo.ClassesDoJogo.itens.Material;
import jogo.Globals;

import java.util.HashMap;
import java.util.Map;

public class MapManager {
    final private Mapa mapa;
    final private int gridX = 11;
    final private int gridY = 11;
    //final private double paneSize = 50;
    final private Pane[][] matrizPanes = new Pane[gridX][gridY];
    final private Label[][] matrizLabels = new Label[gridX][gridY];

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
                pane.setPrefSize(50, 50);
                gridMap.add(pane, col, row);
                matrizPanes[col][row] = pane;

                Label label;
                if(row == offY && col == offX){
                    label = new Label(" @");
                } else {
                    label = new Label(" ?");
                }
                pane.getChildren().add(label);
                matrizLabels[col][row] = label;
            }
        }
    }

    public void exibirMapa(int posX, int posY){
        double visao = mapa.getJogador().getVisao();
        int offX = (int) Math.floor(((double) gridX-1)/2);
        int offY = (int) Math.floor(((double) gridY-1)/2);
        Ambiente[][] matrizAmbientes = mapa.getMatrizAmbientes();

        GridPane gridMap = Globals.getMainWindow().getGridMap();
        double panesizeX = gridMap.getWidth()/gridX;
        double panesizeY = gridMap.getHeight()/gridY;

        for(int row = 0; row < gridY; row++){
            for(int col = 0; col < gridX; col++){
                Pane pane = matrizPanes[col][row];
                Label label = matrizLabels[col][row];
                int realY = row-offY+posY;
                int realX = col-offX+posX;
                if(0<= realX && realX < mapa.maxX && 0<= realY && realY < mapa.maxY){
                    Ambiente ambiente = matrizAmbientes[realX][realY];
                    if (Math.pow(row-offY, 2) + Math.pow(col - offX, 2) <= Math.pow(visao, 2)){
                        pane.setStyle(ambiente.getAparencia());

                        if(row == offY && col == offX){
                            label.setText(" @");
                        } else {
                            if (ambiente.isVisitado()){
                                label.setText("");
                            } else {
                                label.setText(" ?");
                            }
                        }
                    } else {
                        if(ambiente.isVisitado()){
                            pane.setStyle(ambiente.getAparencia());
                            label.setText("");
                        } else {
                            pane.setStyle("-fx-background-color: black");
                            label.setText("");
                        }
                    }
                }
                else{
                    pane.setStyle("-fx-background-color: black");
                    label.setText(" X");
                }
                pane.setPrefSize(panesizeX, panesizeY);
                label.setPrefSize(panesizeX, panesizeY);
                label.setStyle("-fx-text-fill: white; -fx-font-size: " + 0.8*panesizeY+ "px");
            }

        }

    }

    public void onAmbienteExplorado(Ambiente ambiente){

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
            if(item instanceof Material && ((Material) item).tipoFerramenta != null){
                actions.put("Coletar | Requer "+((Material) item).tipoFerramenta, ()->{
                    if(mapa.getJogador().getFerramentaEquipada().tipo.equals(((Material) item).tipoFerramenta)){
                        caixaItens.getChildren().remove(line);
                        ambiente.getItems().remove(item);
                        mapa.getJogador().getInventario().adicionarItem(item);
                        mapa.getJogador().getFerramentaEquipada().usar();
                    }
                });
                line.setOnMouseClicked(event -> {
                    Globals.getMainWindow().makeOptionsPopup(actions, event);
                });
            } else {
                actions.put("Coletar", ()->{
                    caixaItens.getChildren().remove(line);
                    ambiente.getItems().remove(item);
                    mapa.getJogador().getInventario().adicionarItem(item);
                });
                line.setOnMouseClicked(event -> {
                    Globals.getMainWindow().makeOptionsPopup(actions, event);
                });
            }
        }
    }

}
