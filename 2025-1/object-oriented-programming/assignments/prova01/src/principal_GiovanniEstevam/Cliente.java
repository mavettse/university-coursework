package principal_GiovanniEstevam;

public class Cliente extends Pessoa {
    private double carteira;

    public Cliente(String nome, String cpf, String contato, double carteira) {
        super(nome, cpf, contato);
        this.carteira = carteira;
    }

    public boolean pagarCorrida(double valor) {
        if (carteira >= valor) {
            carteira -= valor;
            return true;
        }
        return false; // Saldo insuficiente
    }

    public double getCarteira() {
        return carteira;
    }
}
