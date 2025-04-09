package jogo;
import jogo.ClassesDoJogo.Inventario;
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

    public static int askForIntInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        //launch();

        Jogador jogador = new Jogador("Aventureiro", 100, 25, 100, 100);

        Mapa mapa = jogador.getMapa();

        Inventario inventario = jogador.getInventario();


        Alimento maca = new Alimento("Maçã");

        Alimento pao = new Alimento("Pão");

        jogador.getInventario().adicionarItem(maca);
        jogador.getInventario().adicionarItem(pao);

        System.out.println("Bem vindo ao jogo!");
        while (true){
            System.out.println("----------------------------------");
            int n = askForIntInput("Digite:\n" +
                    "1 Para ver o seu Status \n" +
                    "2 Para ver seu Inventario \n" +
                    "3 Para ver o mapa\n" +
                    "4 para se mover\n");
            System.out.println("----------------------------------");
            Scanner scann = new Scanner(System.in);
            switch (n) {
                case 1: {
                    jogador.exibirStatus();
                    break;
                }
                case 2: {
                    inventario.listarItens();
                    int a = askForIntInput("Digite o numero do objeto que você quer usar/olhar, ou digite outra coisa para sair.\n");
                    if(a>0 && a <= inventario.getSize()){
                        inventario.getItem(a-1).integarir();
                    } else if(a!=-1) {
                        System.out.println("Posição não existe no inventario.");
                    }


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
                            "D Para se mover para direita \n" +
                            "Q Para explorar o mesmo lugar novamente \n" +
                            "Qualquer outra coisa para sair \n");
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
                        case "Q":{
                            mapa.explorar(x,y);
                            break;
                        }
                        default:{
                            System.out.println("Comando Invalido!");
                        }
                    }
                    break;
                }
                default: {
                    System.out.print("Comando Invalido");
                    break;
                }
            }
        }
    }
}