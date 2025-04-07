package jogo.ClassesDoJogo.itens;

public class Bebida extends Item{
    private int valorSede;

    public Bebida(String nome, double peso, int durabilidade, int valorSede){
        super(nome, peso, durabilidade);
        this.valorSede = valorSede;
    }

    public void beber(){
        getInventario().getJogador().addSede(this.valorSede);
        removeDurabilidade(1);
        if(getDurabilidade() < 1){
            selfDestruir();
        }
        System.out.println("Consumindo " + getNome() + ", restaurando " + valorSede + " pontos de sede.");
    }

    private record Data (String nome, double peso, int durabilidade, int valorSede){};

    private static Data pegarData(String nome){
        return switch (nome){
            case "Maçã" ->  new Data("Maçã", 0.2, 1, 10);
            case "Pão" -> new Data("Pão", 0.5, 1,20);
            default -> new Data("Vazio",0,1,0);
        };
    };

    public Bebida(String nome){
        super(pegarData(nome).nome(), pegarData(nome).peso(), pegarData(nome).durabilidade());
        valorSede = pegarData(nome).valorSede;
    }


}
