package principal_GiovanniEstevam;

public class Motorista extends Pessoa {
    private double faturamento;

    public Motorista(String nome, String cpf, String contato){
        super(nome, cpf, contato);
        faturamento = 0;
    }

    public void motoristaValorCorrida(double faturamento){
        this.faturamento += faturamento;
    }

    public double getFaturamento() {
        return faturamento;
    }
}
