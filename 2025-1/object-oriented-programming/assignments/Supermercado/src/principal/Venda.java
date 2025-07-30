package principal;

public class Venda {
    private final ItemProduto[] carrinho;
    private final double[] subtotal;
    private double valorTotal;
    
    //construtor
    public Venda(int tamanho){
        carrinho = new ItemProduto[tamanho];
        subtotal = new double[tamanho];
    }
    
    //getter
    public double getValorTotal(){
        return valorTotal;
    }
    
    //metodos
    public boolean addItemProduto(ItemProduto item, int quantidade){
        for(int i = 0; i < carrinho.length; i++)
            if(carrinho[i] == null){
                Produto produto = item.getProduto();
                carrinho[i] = new ItemProduto(produto, quantidade);
                subtotal[i] = carrinho[i].getValor();
                valorTotal += subtotal[i];
                return true;
            }
        return false;
    }
    
    public String listarProdutos(){
        String retorno = "------- CUPOM FISCAL -------\n";
        for(int i = 0; i < carrinho.length; i++)
            if(carrinho[i] != null)
                retorno += carrinho[i].getProduto().getDescricao() + " R$ " + subtotal[i] + "\n";
        retorno += "----------------------------\nTotal R$ " + valorTotal;
        return retorno;
    }
    
}