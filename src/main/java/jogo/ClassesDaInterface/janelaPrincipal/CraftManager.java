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
            String nome = Globals.Ferramentas.criar(entry.getKey()).getNome();
            Map<String,Integer> receita = entry.getValue();
            String labelText = nome+" | "+descreverReceita(receita);
            Runnable runnable;

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
            String nome = Globals.Armas.criar(entry.getKey()).getNome();
            Map<String,Integer> receita = entry.getValue();
            String labelText = nome+" | "+descreverReceita(receita);
            Runnable runnable;

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
                crafter.craftArma(nome);
            });
        }

        for(Map.Entry<String, Map<String,Integer>> entry:crafter.listaRecursos.entrySet()){
            String nome = Globals.Recursos.criar(entry.getKey()).getNome();
            Map<String,Integer> receita = entry.getValue();
            String labelText = nome+" | "+descreverReceita(receita);
            Runnable runnable;

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
                crafter.craftRecurso(nome);
            });
        }
    }



}
