package principal;

public class Terceirizado extends Empregado {
    private double horasTrabalhadas;

    public Terceirizado(String nome, String sobrenome, int numIdent, int diaPgto, int mesPgto, double horasTrabalhadas) {
        super(nome, sobrenome, numIdent, diaPgto, mesPgto);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double getValorAPagar(int diaPgto, int mesPgto) {
        return horasTrabalhadas * HORA;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
