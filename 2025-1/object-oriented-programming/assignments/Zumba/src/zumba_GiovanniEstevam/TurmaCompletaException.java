package zumba_GiovanniEstevam;

public class TurmaCompletaException extends Exception {
    public TurmaCompletaException() {
      super("Essa turma já atingiu sua capacidade máxima!");
    }
}
