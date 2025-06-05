package jogo.ClassesDaInterface.janelaPrincipal;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import jogo.ClassesDoJogo.Jogador;
import jogo.ClassesDoJogo.Mapa;
import jogo.Globals;

import java.util.Map;

public class MainWindow {

    private Mapa mapa;
    private Jogador jogador;
    private Pane currentPane;

    @FXML private AnchorPane mainPane; public AnchorPane getMainPane(){ return mainPane; }

    @FXML private AnchorPane craftPane; public AnchorPane getCraftPane() { return craftPane; }

    @FXML private AnchorPane selectPane; public AnchorPane getSelectPane() { return selectPane; }

    @FXML private AnchorPane fimPane; public AnchorPane getFimPane() { return  fimPane; }

    @FXML private VBox caixaInventario; public VBox getCaixaInventario(){ return caixaInventario; }

    @FXML private ScrollPane scroll_inv;

    @FXML private VBox caixaAmbienteItens; public VBox getCaixaAmbienteItens(){ return caixaAmbienteItens; }

    @FXML private VBox caixaAcoes; public VBox getCaixaAcoes() {return caixaAcoes;}

    @FXML private VBox caixaCraftFerramentas; public VBox getCaixaCraftFerramentas() { return caixaCraftFerramentas; }

    @FXML private VBox caixaCraftArmas; public VBox getCaixaCraftArmas() { return caixaCraftArmas; }

    @FXML private VBox caixaCraftRecursos; public VBox getCaixaCraftRecursos() { return caixaCraftRecursos; }

    @FXML private VBox caixaTextos; public VBox getCaixaTextos(){ return caixaTextos; }

    @FXML private GridPane gridMap; public GridPane getGridMap(){ return gridMap; }

    @FXML private Text textoVida; public Text getTextoVida(){ return textoVida; }

    @FXML private Text textoSede; public Text getTextoSede(){ return textoSede; }

    @FXML private Text textoFome; public Text getTextoFome(){ return textoFome; }

    @FXML private Text textoInventario; public Text getTextoInventario(){ return textoInventario; }

    @FXML private Text textoFerramenta; public Text getTextoFerramenta(){ return textoFerramenta; }

    @FXML private Text textoArma; public Text getTextoArma(){ return textoArma; }

    @FXML private Text textoRodada; public Text getTextoRodada(){ return textoRodada; }

    @FXML private Label fimTexto;

    @FXML private Label fimRazao;

    @FXML private Button botaoAbrigo; public Button getBotaoAbrigo(){return  botaoAbrigo;}

    @FXML private Button botaoMedico; public Button getBotaoMedico(){return  botaoMedico;}

    private Node popup;
    public void setPopup(Node newPop){
        if(popup != null){
            try {
                ((Pane) popup.getParent()).getChildren().remove(popup);
            } catch (Error e){
                System.out.println("erro criando o popup!");
                return;
            }
        }
        popup = newPop;
        if(popup != null){
            currentPane.getChildren().add(popup);
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
            vbox.getChildren().addFirst(b);
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
        mapa.iniciarRodada(jogador.getPosX(), jogador.getPosY()-1);
    }

    @FXML
    private void moveDown(ActionEvent event){
        setPopup(null);
        mapa.iniciarRodada( jogador.getPosX(), jogador.getPosY()+1);

    }

    @FXML
    private void moveLeft(ActionEvent event){
        setPopup(null);
        mapa.iniciarRodada( jogador.getPosX()-1, jogador.getPosY());
    }

    @FXML
    private void moveRight(ActionEvent event){
        setPopup(null);
        mapa.iniciarRodada( jogador.getPosX()+1, jogador.getPosY());

    }

    @FXML
    private void moveNowhere(ActionEvent event){
        setPopup(null);
        mapa.iniciarRodada( jogador.getPosX(), jogador.getPosY() );
    }

    private void toggleCraftScreen(){
        if(mainPane.isVisible() && !craftPane.isVisible()){
            mainPane.setVisible(false);
            craftPane.setVisible(true);
            currentPane = craftPane;

            mainPane.getChildren().remove(scroll_inv);
            mainPane.getChildren().remove(textoInventario);
            craftPane.getChildren().add(scroll_inv);
            craftPane.getChildren().add(textoInventario);

        } else if(!mainPane.isVisible() && craftPane.isVisible())  {
            craftPane.setVisible(false);
            mainPane.setVisible(true);
            currentPane = mainPane;

            craftPane.getChildren().remove(scroll_inv);
            craftPane.getChildren().remove(textoInventario);
            mainPane.getChildren().add(scroll_inv);
            mainPane.getChildren().add(textoInventario);
        }
    }

    @FXML
    private void craftVoltar(ActionEvent event){
        toggleCraftScreen();
    }

    @FXML
    private void craftMostrar(ActionEvent event){
        toggleCraftScreen();
    }

    public Button addAcao(String texto, Runnable runnable){
        Button line = new Button();
        line.setPrefWidth(4096);
        line.setPrefHeight(30);
        line.setAlignment(Pos.CENTER);
        line.setText(texto);
        line.setStyle(
                "-fx-border-color: black;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 5;" +
                        "-fx-background-color: white;"
        );
        MainWindow mainWindow = Globals.getMainWindow();
        mainWindow.getCaixaAcoes().getChildren().add(line);
        line.setOnMouseClicked( event ->{
            runnable.run();
        });
        return line;
    }

    @FXML private void medicoCurar(ActionEvent event){
        jogador.addVida(5, "Curando 5 de pontos vida, consumindo 5 pontos de fome e sede");
        jogador.addFome(-5);
        jogador.addSede(-5);
    }

    @FXML private void desequiparFerramenta(ActionEvent event){
        jogador.setFerramentaEquipada(null);
    }

    @FXML private void desequiparArma(ActionEvent event){
        jogador.setArmaEquipada(null);
    }

    @FXML private void selectRastreador(ActionEvent event){
        startGame(new Jogador("Rastreador", 100, 25, 100, 100, 1, 5));
    }

    @FXML private void selectSaqueador(ActionEvent event){
        startGame(new Jogador("Saqueador", 100, 40, 100, 100, 1, 3.5));
    }

    @FXML private void selectMedico(ActionEvent event){
        botaoMedico.setVisible(true);
        botaoMedico.setManaged(true);
        startGame(new Jogador("Médico", 100, 25, 100, 100, 1, 3.5));
    }

    @FXML private void selectSobrevivente(ActionEvent event){
        startGame(new Jogador("Sobrevivente", 100, 25, 100, 100, 0.75, 3.5));
    }

    @FXML private void selectSemideus(ActionEvent event){
        startGame(new Jogador("Semideus", 5000, 100, 5000, 5000, 1, 5));
    }

    private void startGame(Jogador jogador){
        selectPane.setVisible(false);
        craftPane.setVisible(false);
        fimPane.setVisible(false);
        mainPane.setVisible(true);
        currentPane = mainPane;

        this.jogador = jogador;
        Mapa mapa = new Mapa(jogador);
        this.mapa = mapa;

        mapa.iniciarJogador(jogador);
        mapa.gerarMapa();
        mapa.carregarAmbienteAtual();

        jogador.getInventario().gerarCrafts();

        addTexto("Bem vindo ao jogo!");

        botaoMedico.setManaged(false);

        Platform.runLater(()->{
            mapa.exibirMapa(jogador.getPosX(), jogador.getPosY());
        });
    }

    public void endGame(boolean win, String razao){
        currentPane.setVisible(false);
        currentPane = fimPane;
        fimPane.setVisible(true);
        if(win){fimTexto.setText("Você venceu!");} else {fimTexto.setText("Você perdeu!");}
        fimRazao.setText(razao);
    }

    public void initialize(){
        System.out.println("init");
        Globals.setMainWindow(this);
        mainPane.setVisible(false);
        craftPane.setVisible(false);
        selectPane.setVisible(true);
        currentPane = selectPane;
    }

}