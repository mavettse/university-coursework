public class Principal {
    public static void main(String[] args) {
        Produto p1 = new Produto(1234, 15.99);
        Venda v1 = new Venda(p1, 4);
        
        p1.exibir();
        v1.exibir();
    }
}
