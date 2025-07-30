package principal;

public class Titulo extends Conta{

    public Titulo(int dia, int mes, double valor) {
        super(dia, mes, valor);
    }

    @Override
    public double getValorAPagar(int diaPgto, int mesPgto) {
        return ((mesPgto > mes || (diaPgto > dia && mesPgto == mes)) ? valor*1.1 : valor);
    }
}
