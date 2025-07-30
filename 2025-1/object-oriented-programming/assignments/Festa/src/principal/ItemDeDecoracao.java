package principal;

import java.util.ArrayList;

public class ItemDeDecoracao {
    private ArrayList<String> itens;
    private double valorAluguel;
    private String corToalha;

    public ItemDeDecoracao(ArrayList<String> itens, double valorAluguel, String corToalha) {
        this.itens = new ArrayList<>(itens);
        this.valorAluguel = valorAluguel;
        this.corToalha = corToalha;
    }

    public ItemDeDecoracao(ItemDeDecoracao item){
        itens = item.getItens();
        valorAluguel = item.getValorAluguel();
        corToalha = item.getCorToalha();
    }

    public ItemDeDecoracao() {
        itens = new ArrayList<>();
        valorAluguel = 0;
        corToalha = "";
    }

    public ArrayList<String> getItens() {
        return new ArrayList<>(itens);
    }

    public void setItens(ArrayList<String> itens) {
        this.itens = new ArrayList<>(itens);
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getCorToalha() {
        return corToalha;
    }

    public void setCorToalha(String corToalha) {
        this.corToalha = corToalha;
    }
}
