package principal.modelo;

public class ValorNaoInformadoException extends Exception {
    public ValorNaoInformadoException() {
        super("Nenhum valor foi informado");
    }
}
