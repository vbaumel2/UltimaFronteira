package jogo;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.itens.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.ClassesDoJogo.itens.Alimento;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();

        Jogador jogador = new Jogador("Aventureiro", 100, 10);

        Alimento maca = new Alimento("Maçã", 0.2, 10);
        Alimento pao = new Alimento("Pão", 0.5, 20);

        jogador.getInventario().adicionarItem(maca);
        jogador.getInventario().adicionarItem(pao);

        jogador.getInventario().listarItens();

        maca.comer();
        jogador.getInventario().listarItens();

        jogador.exibirStatus();

    }
}