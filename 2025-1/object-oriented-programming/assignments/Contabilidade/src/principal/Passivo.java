package principal;

public interface Passivo {
    public final static double SALARIO = 1518;
    public static final double HORA = 65;

    public double getValorAPagar(int diaPgto, int mesPgto);
}
