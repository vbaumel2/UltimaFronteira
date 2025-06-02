package jogo.ClassesDoJogo.itens;

public class Recurso  extends  Item{
    private String ferramentaRequirida;

    public Recurso(String nome, double peso, int durabilidade, String ferramentaRequirida){
        super(nome, peso, durabilidade);
        this.ferramentaRequirida = ferramentaRequirida;
    }

    public String getFerramentaRequirida(){ return  ferramentaRequirida; }

}
