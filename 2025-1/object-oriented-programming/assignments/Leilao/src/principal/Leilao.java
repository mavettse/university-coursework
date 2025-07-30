package principal;

import java.util.ArrayList;

public class Leilao {
    private ArrayList<Lote> lotes;

    public Leilao() {
        lotes = new ArrayList<>();
    }

    public void receberLance(int numLote, String descricaoProduto, Lance lance) {
        if (numLote < 1 || numLote > lotes.size()){
            System.out.println("Lote inválido!");
            return;
        }

        for(Produto aux : lotes.get(numLote-1).getProdutos())
            if(aux.getDescricao().equalsIgnoreCase(descricaoProduto)) {
                aux.verificarMaiorLance(lance);
                return;
            }

        System.out.println("Produto não encontrado no lote.");
    }

    public String listarProdutos(){
        if(lotes.isEmpty())
            return "Não há nenhum produto nos lotes";

        StringBuilder listagem = new StringBuilder("Produtos:" + '\n');
        for (Lote lote : lotes)
            for (Produto aux : lote.getProdutos()) {
                listagem.append(aux.getDescricao());
                if (aux.getMaiorLance().getValorLance() != 0)
                    listagem.append(String.format(" | R$ %.2f", aux.getMaiorLance().getValorLance()));
                listagem.append('\n');
            }


        return listagem.toString();
    }

    public String finalizarLeilao(){
        StringBuilder listagem = new StringBuilder("Vendas realizadas:" + '\n');
        for (Lote lote : lotes)
            for (int j = 0; j < lote.getProdutos().size(); ++j) {
                Produto aux = lote.getProdutos().get(j);
                if(aux.getMaiorLance().getValorLance() == 0)
                    continue;
                listagem.append(String.format("%s | %s | R$ %.2f\n", aux.getDescricao(),
                        aux.getMaiorLance().getPessoa().getNome(), aux.getMaiorLance().getValorLance()));
            }
        if(listagem.toString().length() < 20)
            return "Nenhuma venda foi realizada";

        return listagem.toString();
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }
}
