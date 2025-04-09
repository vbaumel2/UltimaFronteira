package jogo;
import jogo.ClassesDoJogo.Jogador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jogo.ClassesDoJogo.Mapa;
import jogo.ClassesDoJogo.itens.Alimento;
import java.util.Random;

import java.io.IOException;
import java.util.Scanner;

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

        Jogador jogador = new Jogador("Aventureiro", 100, 10, 100, 100);

        Mapa mapa = jogador.getMapa();

        /*
        Alimento maca = new Alimento("Maçã");

        Alimento pao = new Alimento("Pão");

        jogador.getInventario().adicionarItem(maca);
        jogador.getInventario().adicionarItem(pao);

        jogador.getInventario().listarItens();

        maca.consumir();
        jogador.getInventario().listarItens();

        jogador.exibirStatus();

        jogador.getMapa().exibirMapa();
        */
        while (true){
            System.out.println("----------------------------------");
            System.out.print("Digite:\n" +
                    "1 Para ver o seu Status \n" +
                    "2 Para ver seu Inventario \n" +
                    "3 Para ver o mapa\n" +
                    "4 para se mover\n");
            Scanner scann = new Scanner(System.in);
            int n = Integer.parseInt(scann.nextLine());
            System.out.println("----------------------------------");
            switch (n) {
                case 1: {
                    jogador.exibirStatus();
                    break;
                }
                case 2: {
                    jogador.getInventario().listarItens();
                    break;
                }
                case 3: {
                    jogador.getMapa().exibirMapa();
                    break;
                }
                case 4: {
                    System.out.print("Digite:\n" +
                            "W Para se mover para cima \n" +
                            "S Para se mover para baixo \n" +
                            "A Para se mover para esquerda\n" +
                            "D Para se mover para direita \n");
                    String k = scann.nextLine();
                    int x = jogador.getPosX();
                    int y = jogador.getPosY();
                    switch (k) {
                        case "W": {
                            mapa.explorar(x-1, y);
                            break;
                        }
                        case "S": {
                            mapa.explorar(x+1, y);
                            break;
                        }
                        case "A": {
                            mapa.explorar(x, y-1);
                            break;
                        }
                        case "D": {
                            mapa.explorar(x, y+1);
                            break;
                        }
                    }
                }
                default: {
                    System.out.print("Comando Invalido");
                    break;
                }
            }
        }
    }
}