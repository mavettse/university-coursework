package principal_GiovanniEstevam;

public class Cefet {
    private double faturamento;

    public Cefet(){
    }

    public void cefetValorCorrida(double valor){
        faturamento += valor;

    }

    public double getFaturamento() {
        return faturamento;
    }
}
