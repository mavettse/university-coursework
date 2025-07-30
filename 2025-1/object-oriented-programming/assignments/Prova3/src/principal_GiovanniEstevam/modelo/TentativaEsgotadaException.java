package principal_GiovanniEstevam.modelo;

public class TentativaEsgotadaException extends Exception {
    public TentativaEsgotadaException() {
        super("Limite de tentativas atingido");
    }
}
