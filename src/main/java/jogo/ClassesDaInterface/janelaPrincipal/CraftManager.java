package jogo.ClassesDaInterface.janelaPrincipal;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jogo.ClassesDoJogo.Crafter;
import jogo.Globals;

import java.util.Map;

public class CraftManager {
    private Crafter crafter;

    public CraftManager(Crafter crafter){
        this.crafter = crafter;
    }

    private String descreverReceita(Map<String, Integer> receita){
        String ret = "";
        for(Map.Entry<String, Integer> entry: receita.entrySet()){
            String nome = entry.getKey(); if(nome.equals("_q")) continue;
            int qnt = entry.getValue();
            ret = ret + "x"+qnt+" "+nome+"+ ";
        }
        if (ret.length()>=2){
           ret = ret.substring(0, ret.length()-2);
        }
        return ret;
    }

    public void gerarCrafts(){
        MainWindow mainWindow = Globals.getMainWindow();
        AnchorPane craftPane = mainWindow.getCraftPane();
        VBox boxFerramentas = mainWindow.getCaixaCraftFerramentas();
        VBox boxArmas = mainWindow.getCaixaCraftArmas();
        VBox boxRecursos = mainWindow.getCaixaCraftRecursos();

        for(Map.Entry<String, Map<String,Integer>> entry:crafter.listaFerramentas.entrySet()){
            String nome = entry.getKey();
            Map<String,Integer> receita = entry.getValue();
            int q = receita.getOrDefault("_q", 1);
            String labelText = nome+ " (x" + q + ") | "+descreverReceita(receita);

            Button line = new Button();
            line.setPrefWidth(4096);
            line.setPrefHeight(30);
            line.setAlignment(Pos.CENTER);
            line.setText(labelText);
            line.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 5;" +
                            "-fx-background-color: white;"
            );
            boxFerramentas.getChildren().add(line);
            line.setOnMouseClicked( event ->{
                crafter.craftFerramenta(nome);
            });
        }

        for(Map.Entry<String, Map<String,Integer>> entry:crafter.listaArmas.entrySet()){
            String nome = entry.getKey();
            Map<String,Integer> receita = entry.getValue();
            int q = receita.getOrDefault("_q", 1);
            String labelText = nome+ " (x" + q + ") | "+descreverReceita(receita);

            Button line = new Button();
            line.setPrefWidth(4096);
            line.setPrefHeight(30);
            line.setAlignment(Pos.CENTER);
            line.setText(labelText);
            line.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 5;" +
                            "-fx-background-color: white;"
            );
            boxArmas.getChildren().add(line);
            line.setOnMouseClicked( event ->{
                crafter.craftArma(nome);
            });
        }

        for(Map.Entry<String, Map<String,Integer>> entry:crafter.listaRecursos.entrySet()){
            String nome = entry.getKey();
            Map<String,Integer> receita = entry.getValue();
            int q = receita.getOrDefault("_q", 1);
            String labelText = nome+ " (x" + q + ") | "+descreverReceita(receita);

            Button line = new Button();
            line.setPrefWidth(4096);
            line.setPrefHeight(30);
            line.setAlignment(Pos.CENTER);
            line.setText(labelText);
            line.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 5;" +
                            "-fx-background-color: white;"
            );
            boxRecursos.getChildren().add(line);
            line.setOnMouseClicked( event ->{
                crafter.craftRecurso(nome);
            });
        }

        Map<String, Integer> receitaAbrigo = Map.of(
                "_q",1,
                "Madeira",2,
                "Graveto", 4,
                "Rocha",1,
                "Pedra", 2,
                "Vegetação densa", 1,
                "Vegetação",1,
                "Ferro", 1
        );

        String textoAbrigo = "Criar abrigo permanente (Vence o jogo!)";
        for(Map.Entry<String,Integer> entry:receitaAbrigo.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            if(key.equals("_q")) continue;
            textoAbrigo+="\nx"+val+" "+key;
        }

        Globals.getMainWindow().getBotaoAbrigo().setText(textoAbrigo);

        Globals.getMainWindow().getBotaoAbrigo().setOnMouseClicked(event ->{
            if (crafter.craftItem("Abrigo", "Ferramenta", receitaAbrigo)){
                Globals.getMainWindow().endGame(true, "Fez um abrigo permanente!");
            }
        });
    }



}
