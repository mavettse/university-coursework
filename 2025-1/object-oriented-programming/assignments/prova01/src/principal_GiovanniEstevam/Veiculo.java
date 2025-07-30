package principal_GiovanniEstevam;

public class Veiculo {
    private Motorista motorista;
    private String modelo;
    private String placa;

    public Veiculo(Motorista motorista, String modelo, String placa) {
        this.motorista = motorista;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }
}
