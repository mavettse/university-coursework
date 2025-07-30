public class Produto {
    private int codigo;
    private double preco;
    
    //Construtor
    public Produto(int codigo, double preco){
        this.codigo = codigo;
        this.preco = preco;
    }
    
    //Getters
    public int getCodigo(){
        return codigo;
    }
    public double getPreco(){
        return preco;
    }
    
    //Método
    public void exibir(){
        System.out.println("Produto: " + codigo + " | Preco: R$ " + preco);
    }
}
