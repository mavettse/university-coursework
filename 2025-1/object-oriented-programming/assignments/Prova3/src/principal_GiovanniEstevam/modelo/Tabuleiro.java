package principal_GiovanniEstevam.modelo;

import java.util.Random;

public class Tabuleiro {
    private Peca[][] pecas;
    private final int LINHAS = 3;
    private final int COLUNAS = 4;

    public Tabuleiro(){
        inicializarPecas();
    }

    private void inicializarPecas() {
        pecas = new Peca[LINHAS][COLUNAS];

        for (int linha = 0; linha < LINHAS; linha++)
            for (int coluna = 0; coluna < COLUNAS; coluna++)
                    pecas[linha][coluna] = new Peca();

    }

    public void embaralhar(){
        Random aleatorio = new Random();

        int[] numeros = new int[LINHAS * COLUNAS];
        int aux = 0;
        for (int i = 1; i <= 6; i++) {
            numeros[aux++] = i;
            numeros[aux++] = i;
        }

        for (int i = numeros.length - 1; i > 0; i--) {
            int j = aleatorio.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = temp;
        }

        aux = 0;

        for (int linha = 0; linha < LINHAS; linha++)
            for (int coluna = 0; coluna < COLUNAS; coluna++)
                pecas[linha][coluna].setValor(numeros[aux++]);

    }

    public Peca getPeca(int linha, int coluna) {
        return pecas[linha][coluna];
    }

    public int getLINHAS() {
        return LINHAS;
    }

    public int getCOLUNAS() {
        return COLUNAS;
    }
}
