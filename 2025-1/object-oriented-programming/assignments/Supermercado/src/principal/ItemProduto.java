package principal;

public class ItemProduto { // meu item produto só será alterado dentro do código, não no console
    private Produto produto;
    private int quantidade;
    private double valor;
    
    //construtor
    public ItemProduto(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        atualizarValor();
    }
    
    //setters e getters
    public void setProduto(Produto produto){
        this.produto = produto;
        atualizarValor();
    }
    
    public void setQuantidade(int quantidade){
        if(quantidade >= 0){
            this.quantidade = quantidade;
            atualizarValor();
        }
    }
    
    private void atualizarValor(){
        this.valor = this.quantidade * this.produto.getValor();
    }
  
    public Produto getProduto(){
        return produto;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public double getValor(){
        return valor;
    }
    
}