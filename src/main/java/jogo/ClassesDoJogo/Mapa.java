package jogo.ClassesDoJogo;

import jogo.ClassesDoJogo.ambientes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jogo.ClassesDaInterface.janelaPrincipal.MapManager;
import jogo.ClassesDoJogo.eventos.GerenciadorEventos;
import jogo.Globals;

public class Mapa {
    private Jogador jogador;
    private int rodada = 0;
    public final int maxX = 36;
    public final int maxY = 36;
    final private Ambiente[][] matrizAmbientes = new Ambiente[maxX][maxY];
    final private Boolean[][] ambientesVisitados = new Boolean[maxX][maxY];
    private double pesoSede = 5;
    private double pesoFome = 5;
    private  MapManager mapManager;
    public GerenciadorEventos gerenciadorEventos;
    private List<Runnable> runnables;


    public Mapa(Jogador jogador){
        this.mapManager = new MapManager(this);
        this.jogador = jogador;
        this.gerenciadorEventos = new GerenciadorEventos(this);
        runnables = new ArrayList<>();
    }

    public Jogador getJogador() {
        return jogador;
    }

    private void mudarClima(){
       double d = Math.random()-0.5;
       d = Math.max(pesoSede-3, d);
       d = Math.min(3-pesoFome, d);
       pesoFome+=d;
       pesoSede-=d;
    }

    public void centrarJogador(Jogador jogador){
        int xf = (int) Math.floor(((double) maxX -1)/2);
        int yf = (int) Math.floor(((double) maxY -1)/2);
        jogador.setPos(xf, yf);
    }

    private Ambiente ambienteAleaotorio(){
        Map<Class<?>, Double> lista = Map.of(
                Floresta.class,5.0,
                Deserto.class,4.0,
                Lago.class,4.0,
                Montanha.class,3.0,
                Caverna.class,2.0,
                Ruinas.class, 1.0
        );

        double totalWeight = lista.values().stream().mapToDouble(Double::doubleValue).sum();
        if (totalWeight <= 0) throw new IllegalArgumentException("Peso tem q ser > 0");

        double random = Math.random() * totalWeight;

        double cumulative = 0.0;
        for (Map.Entry<Class<?>, Double> entry : lista.entrySet()) {
            cumulative += entry.getValue();
            if (random <= cumulative) {
                try {
                    return (Ambiente) entry.getKey().getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + entry.getKey().getName(), e);
                }
            }
        }
        try {
            return (Ambiente) lista.entrySet()
                    .iterator()
                    .next()
                    .getKey()
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Falha em instantciar Ambiente", e);
        }
    }

    public void gerarMapa(){
        int xf = (int) Math.floor(((double) maxX -1)/2);
        int yf = (int) Math.floor(((double) maxY -1)/2);
        matrizAmbientes[xf][yf] = new Inicio();

        for(int i = 0; i < maxX; i++){
            for(int j = 0; j < maxY; j++){
                if(matrizAmbientes[i][j] == null) matrizAmbientes[i][j] = ambienteAleaotorio();
            }
        }

        mapManager.gerarMapa();
    }


    public void iniciarRodada(int x, int y){
        if(x < maxX && 0<= x && 0 <= y && y < maxY){
            jogador.setPos(x,y);
            Ambiente ambiente = getAmbienteAtual();
            gerenciadorEventos.tentarEventos(ambiente);
            for(Runnable r:new ArrayList<>(runnables)) r.run();
            ambiente.explorar(jogador, this);
            exibirMapa(x, y);
            mapManager.onAmbienteExplorado( matrizAmbientes[x][y]);
            mudarClima();
            rodada++;
            Globals.getMainWindow().getTextoRodada().setText("RODADA: "+rodada);
        } else {
            System.out.println("Posição fora do mapa!");
            Globals.getMainWindow().addTexto("Local fora do mapa!", "red");
        }
    }

    public void carregarAmbienteAtual(){
        mapManager.onAmbienteExplorado(getAmbienteAtual());
    }

    public void exibirMapa(int x, int y){
        mapManager.exibirMapa(x,y);
    }

    public Ambiente getAmbienteAtual(){
        return matrizAmbientes[jogador.getPosX()][jogador.getPosY()];
    }

    public Ambiente[][] getMatrizAmbientes(){
        return matrizAmbientes;
    }

    public void addCappedRunnable(int runLimit, Runnable task, Runnable onEnd) {
        runnables.add(new Runnable(){
            int runCount = 0;
            @Override
            public void run() {
                if (runCount < runLimit) {
                    task.run();
                    runCount++;
                    if (runCount >= runLimit) {
                        runnables.remove(this);
                        onEnd.run();
                    }
                }
            }
        });
    }

    public void addRunnable(Runnable runnable){
        runnables.add(runnable);
    }

    public boolean removeRunnable(Runnable runnable){
        return runnables.remove(runnable);
    }

    public double getPesoSede(){return pesoSede;}
    public double getPesoFome(){return pesoFome;}

}
