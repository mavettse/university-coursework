package principal;

public class Concessionaria extends Conta{

    public Concessionaria(int dia, int mes, double valor) {
        super(dia, mes, valor);
    }

    @Override
    public double getValorAPagar(int diaPgto, int mesPgto) {
        return valor;
    }
}
