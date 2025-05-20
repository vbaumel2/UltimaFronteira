package jogo.ClassesDaInterface.janelaPrincipal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.Globals;

public class MainWindow {

    @FXML
    private AnchorPane mainPane;
    @FXML
    public AnchorPane getMainPane(){ return mainPane; }

    private Node popup;
    public void setPopup(Node newPop){
        if(popup != null){
            mainPane.getChildren().remove(popup);
        }
        popup = newPop;
        if(popup != null){
            mainPane.getChildren().add(popup);
        }
    }

    @FXML
    private GridPane gridMap;
    @FXML
    public GridPane getGridMap(){ return gridMap; }

    @FXML
    private VBox caixaTextosExploracao;
    @FXML
    public VBox getCaixaTextosExploracao(){
        return caixaTextosExploracao;
    }

    @FXML
    private VBox caixaInventario;
    @FXML
    public VBox getCaixaInventario(){
        return caixaInventario;
    }

    @FXML
    private Text textoSede;
    @FXML
    public Text getTextoSede(){
        return textoSede;
    }

    @FXML
    private Text textoFome;
    @FXML
    public Text getTextoFome(){
        return textoFome;
    }

    @FXML
    private void moveUp(ActionEvent event){
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.explorar(jogador, jogador.getPosX()-1, jogador.getPosY() );
    }

    @FXML
    private void moveDown(ActionEvent event){
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.explorar(jogador, jogador.getPosX()+1, jogador.getPosY() );

    }

    @FXML
    private void moveLeft(ActionEvent event){
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.explorar(jogador, jogador.getPosX(), jogador.getPosY()-1 );
    }

    @FXML
    private void moveRight(ActionEvent event){
        Mapa mapa = Globals.getMapa();
        Jogador jogador = Globals.getJogador();
        mapa.explorar(jogador, jogador.getPosX(), jogador.getPosY()+1 );

    }

    private VBox caixaTextosAmbiente;

    public void initialize(){
        System.out.println("init");
        Globals.setMainWindow(this);
        Jogador jogador = new Jogador("Aventureiro", 100, 25, 100, 100);
        Globals.setJogador(jogador);
        Mapa mapa = new Mapa();
        Globals.setMapa(mapa);

        mapa.centrarJogador(jogador);
        mapa.gerarMapa();

        mapa.addTextoExploracao("Bem vindo ao jogo!");

        mapa.exibirMapa(jogador.getPosX(), jogador.getPosY());
    }

}