package principal;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        EquacaoSegundoGrau eq = new EquacaoSegundoGrau();

        try {
            System.out.println("Eq: x^2 - 5x + 6 = 0 -> Raizes: " + Arrays.toString(eq.calcularRaizes(1, -5, 6))); // Delta > 0
            System.out.println("Eq: x^2 - 4x + 4 = 0 -> Raizes: " + Arrays.toString(eq.calcularRaizes(1, -4, 4))); // Delta = 0
            System.out.println("Eq: x^2 + 2x + 5 = 0 -> Raizes: " + Arrays.toString(eq.calcularRaizes(1, 2, 5)));  // Delta < 0
            System.out.println("Eq: 2x^2 - 8 = 0   -> Raizes: " + Arrays.toString(eq.calcularRaizes(2, 0, -8))); // b = 0, Delta > 0
            System.out.println("Eq: 3x^2 + 6x = 0  -> Raizes: " + Arrays.toString(eq.calcularRaizes(3, 6, 0)));  // c = 0, Delta > 0
            System.out.println("Eq: -x^2 - 1 = 0   -> Raizes: " + Arrays.toString(eq.calcularRaizes(-1, 0, -1))); // b = 0, Delta < 0

            // Teste da exceção
            System.out.println("\nTentando calcular com a = 0:");
            eq.calcularRaizes(0, 5, 2);

        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
