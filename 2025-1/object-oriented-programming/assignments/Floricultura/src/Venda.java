public class Venda {
    private Produto produto;
    private int quantidade;
    private double total;
    
    //Construtor
    public Venda(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = produto.getPreco() * quantidade;
    }
    
    //Método
    public void exibir(){
        System.out.println("Venda do produto: " + produto.getCodigo() + " | Quantidade: " + quantidade + " | Total: R$ " + total);
    }
}
