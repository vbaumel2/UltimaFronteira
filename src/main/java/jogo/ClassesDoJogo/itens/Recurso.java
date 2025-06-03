package jogo.ClassesDoJogo.itens;

public class Recurso  extends  Item {
    final public String tipoFerramenta;
    private String tipoDeFerramentaRequirido;

    public Recurso(String nome, double peso, int durabilidade, String tipoFerramenta){
        super(nome, peso, durabilidade);
        this.tipoFerramenta = tipoFerramenta;
        this.tipoDeFerramentaRequirido = tipoFerramenta;
    }

    @Override
    public String toString(){
        return "Recurso: "+getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade();
    }

}
