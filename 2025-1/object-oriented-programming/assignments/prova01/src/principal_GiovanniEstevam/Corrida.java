package principal_GiovanniEstevam;

public class Corrida {
    private Cefet cefet;
    private Veiculo carro;
    private Cliente cliente;
    private double distancia;
    private double valorCorrida;

    public Corrida(Cefet cefet, Veiculo carro, Cliente cliente, double distancia) {
        this.cefet = cefet;
        this.carro = carro;
        this.cliente = cliente;
        this.distancia = distancia;
        valorCorrida = calcularValorCorrida();

        if (cliente.pagarCorrida(valorCorrida)) {
            calcularValores();
        } else {
            System.out.println("Saldo insuficiente para a corrida.");
        }
    }

    private double calcularValorCorrida(){
        return distancia*0.003; // tres reais por quilômetro (a distância será dada em metros)
    }

    private void calcularValores(){
        double valorMotorista = valorCorrida*0.7;
        double valorCefet = valorCorrida*0.3;

        carro.getMotorista().motoristaValorCorrida(valorMotorista);
        cefet.cefetValorCorrida(valorCefet);

    }

    public Veiculo getCarro() {
        return carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getValorCorrida() {
        return valorCorrida;
    }
}
