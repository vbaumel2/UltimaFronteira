package jogo.ClassesDaInterface.janelaPrincipal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.Globals;

import java.util.Map;

public class MainWindow {

    @FXML
    private AnchorPane mainPane;
    public AnchorPane getMainPane(){ return mainPane; }

    @FXML
    private VBox caixaInventario; public VBox getCaixaInventario(){ return caixaInventario; }

    @FXML
    private VBox caixaAmbienteItens; public VBox getCaixaAmbienteItens(){ return caixaAmbienteItens; }

    @FXML
    private GridPane gridMap; public GridPane getGridMap(){ return gridMap; }

    @FXML
    private Text textoVida; public Text getTextoVida(){ return textoVida; }

    @FXML
    private Text textoSede; public Text getTextoSede(){ return textoSede; }

    @FXML
    private Text textoFome; public Text getTextoFome(){ return textoFome; }

    @FXML
    private Text textoInventario; public Text getTextoInventario(){ return textoInventario; }

    private Node popup;
    public void setPopup(Node newPop){
        if(popup != null){
            try {
                mainPane.getChildren().remove(popup);
            } catch (Error e){
                System.out.println("erro criando o popup!");
                return;
            }
        }
        popup = newPop;
        if(popup != null){
            mainPane.getChildren().add(popup);
        }
    }

    public void makeOptionsPopup(Map<String, Runnable> actions, MouseEvent mouseEvent){
        Point2D localPoint = mainPane.sceneToLocal(mouseEvent.getSceneX(), mouseEvent.getSceneY());
        VBox vbox = new VBox(5);
        vbox.setLayoutX(localPoint.getX());
        vbox.setLayoutY(localPoint.getY() + 10);
        for (Map.Entry<String, Runnable> entry : actions.entrySet()) {
            System.out.println(entry.getKey());
            Button b = new Button(entry.getKey());
            b.setOnAction(e -> {
                entry.getValue().run();
                setPopup(null);
            });
            vbox.getChildren().addLast(b);
            b.setAlignment(Pos.CENTER);
        }
        vbox.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 5;" +
                        "-fx-background-color: white;"
        );

        setPopup(vbox);
    }

    @FXML
    private VBox caixaTextos; public VBox getCaixaTextos(){ return caixaTextos; }
    public void addTexto(String texto, String backgroundColor){
        Label line = new Label(texto);
        line.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 5;" +
                        String.format("-fx-background-color: %s;", backgroundColor)
        );
        line.setPrefWidth(caixaTextos.getPrefWidth()-5);
        line.setWrapText(true);
        line.setAlignment(Pos.TOP_LEFT);
        caixaTextos.getChildren().addFirst(line);
    }
    public void addTexto(String texto){ addTexto(texto, "white");}

    @FXML
    private void moveUp(ActionEvent event){
        setPopup(null);
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.iniciarRodada(jogador, jogador.getPosX()-1, jogador.getPosY() );
    }

    @FXML
    private void moveDown(ActionEvent event){
        setPopup(null);
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.iniciarRodada(jogador, jogador.getPosX()+1, jogador.getPosY() );

    }

    @FXML
    private void moveLeft(ActionEvent event){
        setPopup(null);
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.iniciarRodada(jogador, jogador.getPosX(), jogador.getPosY()-1 );
    }

    @FXML
    private void moveRight(ActionEvent event){
        setPopup(null);
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.iniciarRodada(jogador, jogador.getPosX(), jogador.getPosY()+1 );

    }

    @FXML
    private void moveNowhere(ActionEvent event){
        setPopup(null);
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.iniciarRodada(jogador, jogador.getPosX(), jogador.getPosY() );
    }

    public void initialize(){
        System.out.println("init");
        Globals.setMainWindow(this);
        Jogador jogador = new Jogador("Aventureiro", 100, 25, 100, 100);
        Globals.setJogador(jogador);
        Mapa mapa = new Mapa();
        Globals.setMapa(mapa);

        mapa.centrarJogador(jogador);
        mapa.gerarMapa();

        addTexto("Bem vindo ao jogo!");

        mapa.exibirMapa(jogador.getPosX(), jogador.getPosY());
    }

}