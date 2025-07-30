package principal;

public class TesteLeilao {
    public static void main(String[] args) {
        // Criar leilão
        Leilao leilao = new Leilao();

        // Criar lotes
        Lote lote1 = new Lote();
        Lote lote2 = new Lote();

        // Adicionar produtos aos lotes
        lote1.inserirProduto("Produto A");
        lote1.inserirProduto("Produto B");
        lote2.inserirProduto("Produto C");

        // Adicionar lotes ao leilão
        leilao.getLotes().add(lote1);
        leilao.getLotes().add(lote2);

        // Criar pessoas
        Pessoa pessoa1 = new Pessoa("João", "joao@email.com");
        Pessoa pessoa2 = new Pessoa("Maria", "maria@email.com");

        // Criar lances
        Lance lance1 = new Lance(pessoa1, 100.0);
        Lance lance2 = new Lance(pessoa2, 150.0);
        Lance lance3 = new Lance(pessoa1, 50.0);

        // Receber lances
        leilao.receberLance(1, "Produto A", lance1);
        leilao.receberLance(1, "Produto A", lance2); // Lance maior
        leilao.receberLance(2, "Produto C", lance3);

        // Listar produtos
        System.out.println(leilao.listarProdutos());

        // Finalizar leilão
        System.out.println(leilao.finalizarLeilao());
    }
}