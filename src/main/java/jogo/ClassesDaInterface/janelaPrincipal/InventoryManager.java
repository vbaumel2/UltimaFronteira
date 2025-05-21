package jogo.ClassesDaInterface.janelaPrincipal;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jogo.ClassesDoJogo.Inventario;
import jogo.ClassesDoJogo.itens.Item;
import jogo.Globals;

import java.util.Map;
import java.util.HashMap;


public class InventoryManager {
    private Inventario inventario;
    private Map<Item, Button> buttonMap = new HashMap<>();

    public InventoryManager(Inventario inv){
        this.inventario = inv;
    }

    public void adicionarItem(Item item){
        Button line = new Button();
        line.setPrefWidth(4096);
        line.setPrefHeight(30);
        line.setAlignment(Pos.CENTER);
        line.setText(item.toString());
        buttonMap.put(item, line);
        line.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 5;" +
                        "-fx-background-color: white;"
        );
        MainWindow mainWindow = Globals.getMainWindow();
        mainWindow.getCaixaInventario().getChildren().add(line);
        line.setOnMouseClicked( event ->{
            mainWindow.makeOptionsPopup(item.getButtonActions(), event);
        });

        mainWindow.getTextoInventario().setText(String.format("Inventario | Capacidade: %.1f/%.1f",
                inventario.getPesoAtual(), inventario.getPesoMaximo()));
    }

    public void removerItem(Item item){
        Globals.getMainWindow().getCaixaInventario().getChildren().remove(buttonMap.get(item));
        buttonMap.remove(item);
        Globals.getMainWindow().getTextoInventario().setText(String.format("Inventario | Capacidade: %.1f/%.1f",
                inventario.getPesoAtual(), inventario.getPesoMaximo()));
    }


}
