package principal;

public class Assalariado extends Empregado {
    private double horasExtras;

    public Assalariado(String nome, String sobrenome, int numIdent, int diaPgto, int mesPgto, double horasExtras) {
        super(nome, sobrenome, numIdent, diaPgto, mesPgto);
        this.horasExtras = horasExtras;
    }

    @Override
    public double getValorAPagar(int diaPgto, int mesPgto) {
        return (horasExtras > 40 ? SALARIO + (horasExtras-40)*HORA : SALARIO);
    }
}
