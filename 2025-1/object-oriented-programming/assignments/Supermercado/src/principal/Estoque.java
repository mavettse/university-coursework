package principal;

public class Estoque {
    //meu estoque vai ser infinito E não vou conseguir adicionar e remover itens dele no console senão vou passar perrengue demais (desculpa, luciana, to penando e aprendendo ainda)
    private final ItemProduto[] estante;
    
    //construtor
    public Estoque(int quantidade){
        estante = new ItemProduto[quantidade];
    }
    
    //metodos
    public boolean addItemProduto(ItemProduto item){
        for(int i = 0; i < estante.length; i++)
            if(estante[i] == null){
                estante[i] = item;
                return true;    
            }
        return false;
    }
    
    public ItemProduto consultarItemProduto(int codigo){
        for(ItemProduto aux : estante)
            if(aux != null && aux.getProduto() != null && aux.getProduto().getCodigo() == codigo)
                return aux;
        return null; //se não for encontrado o produto com o codigo inserido
    }
    
    public String listarProdutos(){
            String retorno = "Produtos em estoque:\n";
            boolean vazio = true;
        for(ItemProduto aux : estante) //for-each - laço que faz com que aux receba o valor de estante a cada iteração
            if(aux != null){
                retorno += aux.getProduto().getCodigo() + " - " + aux.getProduto().getDescricao() + " R$ " + aux.getProduto().getValor() + "\n";
                vazio = false;
            }
                
        return vazio ? "Estoque vazio\n" : retorno;
    }
    
}