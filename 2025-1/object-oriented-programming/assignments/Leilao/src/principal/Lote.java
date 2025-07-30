package principal;

import java.util.ArrayList;

public class Lote {
    private ArrayList<Produto> produtos;

    public Lote() {
        produtos = new ArrayList<>();
    }

    public void inserirProduto(String descricao) {
        if (!produtos.isEmpty())
            for (Produto temp : produtos)
                if (temp.getDescricao().equalsIgnoreCase(descricao)) {
                    System.out.println("Já existe um produto com essa descrição");
                    return;
                }

        Produto temp = new Produto(descricao);
        produtos.add(temp);
        System.out.println("Produto adicionado com sucesso!");
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
