package principal;

public class AssalariadoComissionado extends Comissionado {
    private double percentualBonus;

    public AssalariadoComissionado(String nome, String sobrenome, int numIdent, int diaPgto, int mesPgto, double valorVendas, double percentualBonus) {
        super(nome, sobrenome, numIdent, diaPgto, mesPgto, valorVendas);
        this.percentualBonus = percentualBonus;
    }

    @Override
    public double getValorAPagar(int diaPgto, int mesPgto) {
        return SALARIO + percentualBonus*getValorVendas();
    }

    public double getPercentualBonus() {
        return percentualBonus;
    }

    public void setPercentualBonus(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }
}
