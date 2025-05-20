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
        Globals.getMainWindow().getCaixaInventario().getChildren().add(line);
        line.setOnMouseClicked( event ->{
            AnchorPane mainPane = Globals.getMainWindow().getMainPane();
            Point2D localPoint = mainPane.sceneToLocal(event.getSceneX(), event.getSceneY());
            VBox vbox = new VBox(5); // spacing 5
            vbox.setLayoutX(localPoint.getX());
            vbox.setLayoutY(localPoint.getY() + 10);
            for (Map.Entry<String, Runnable> entry : item.getButtonActions().entrySet()) {
                System.out.println(entry.getKey());
                Button b = new Button(entry.getKey());
                b.setOnAction(e -> {
                    entry.getValue().run();
                    Globals.getMainWindow().setPopup(null);
                });
                vbox.getChildren().add(b);
            }
            vbox.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 5;" +
                            "-fx-background-color: white;"
            );

            Globals.getMainWindow().setPopup(vbox);


        });
    }

    public void removerItem(Item item){
        Globals.getMainWindow().getCaixaInventario().getChildren().remove(buttonMap.get(item));
        buttonMap.remove(item);
    }


}
