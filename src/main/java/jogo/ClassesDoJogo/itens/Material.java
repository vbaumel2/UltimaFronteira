package jogo.ClassesDoJogo.itens;

public class Material extends  Item {
    final public String tipoFerramenta;
    private String tipoDeFerramentaRequirido;

    public Material(String nome, double peso, int durabilidade, String tipoFerramenta){
        super(nome, peso, durabilidade);
        this.tipoFerramenta = tipoFerramenta;
        this.tipoDeFerramentaRequirido = tipoFerramenta;
    }

    @Override
    public String toString(){
        return "Material: "+getNome()+ " | Peso: " + getPeso() + " | Usos: "+ getDurabilidade();
    }

}
