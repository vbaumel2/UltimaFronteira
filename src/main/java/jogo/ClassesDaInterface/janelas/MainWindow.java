package jogo.ClassesDaInterface.janelas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainWindow {

    @FXML
    private GridPane gridMap;

    @FXML
    public GridPane getGridMap(){ return gridMap; }

}