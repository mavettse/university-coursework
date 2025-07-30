package principal;

public class Lance {
    private Pessoa pessoa;
    private double valorLance;

    public Lance() {
        pessoa = new Pessoa();
        valorLance = 0;
    }

    public Lance(Pessoa pessoa, double valorLance) {
        if(valorLance <= 0){
            System.out.println("Valor inválido");
            return;
        }

        this.pessoa = pessoa;
        this.valorLance = valorLance;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public double getValorLance() {
        return valorLance;
    }
}
