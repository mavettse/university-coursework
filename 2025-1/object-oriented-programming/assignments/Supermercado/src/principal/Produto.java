package principal;

public class Produto { //produtos só serão adicionados dentro do código, não no console
    private String descricao;
    private int codigo;
    private double valor;
    
    //construtor
    public Produto(String descricao, int codigo, double valor){
        this.descricao = descricao;
        this.codigo = codigo;
        this.valor = valor;
    }
    
    //setters e getters 
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setValor(double valor){
        if(valor >= 0)
            this.valor = valor;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public double getValor(){
        return valor;
    }
        
}