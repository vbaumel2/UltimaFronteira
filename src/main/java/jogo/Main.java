package jogo;
import javafx.scene.text.Text;
import jogo.ClassesDoJogo.Jogador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.ClassesDoJogo.Mapa;

import java.io.IOException; 
import java.util.Map;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Ultima Fronteira");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);



    }
}