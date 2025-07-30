package principal.modelo;

public class CaracterInvalidoException extends Exception {
    public CaracterInvalidoException() {
      super("Caracter inválido digitado");
    }
}
