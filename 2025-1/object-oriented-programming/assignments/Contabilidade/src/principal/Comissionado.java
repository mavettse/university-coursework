package principal;

public class Comissionado extends Empregado {
    private double valorVendas;

    public Comissionado(String nome, String sobrenome, int numIdent, int diaPgto, int mesPgto, double valorVendas) {
        super(nome, sobrenome, numIdent, diaPgto, mesPgto);
        this.valorVendas = valorVendas;
    }

    @Override
    public double getValorAPagar(int diaPgto, int mesPgto) {
        return valorVendas*0.6;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }
}
