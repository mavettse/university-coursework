package principal_GiovanniEstevam.visao;

import principal_GiovanniEstevam.modelo.Jogo;
import principal_GiovanniEstevam.modelo.Peca;
import principal_GiovanniEstevam.modelo.Tabuleiro;
import principal_GiovanniEstevam.modelo.TentativaEsgotadaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();
        jogo.iniciarNovoJogo();

        System.out.println("--- JOGO DA MEMÓRIA NUMÉRICA ---");
        System.out.println("Você tem " + jogo.MAX_TENTATIVAS + " tentativas para encontrar 6 pares.");

        try {
            while (!jogo.isFimDeJogo()) {
                imprimirTabuleiro(jogo);

                System.out.println("\n--- Sua vez de jogar ---");
                int[] jogada1 = lerEntrada(scanner, jogo, 1);
                jogo.escolherPeca(jogada1[0], jogada1[1]);
                imprimirTabuleiro(jogo);

                int[] jogada2 = lerEntrada(scanner, jogo, 2);
                jogo.escolherPeca(jogada2[0], jogada2[1]);

                System.out.println("\n--- Resultado da Jogada ---");
                imprimirTabuleiro(jogo);

                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();

                jogo.resetarJogadaIncorreta();
            }

            System.out.println("\n--- FIM DE JOGO ---");
            if (jogo.isVitoria())
                System.out.println("PARABÉNS! Você venceu!");
            else
                System.out.println("Você perdeu!");
            System.out.println("Pontuação final: " + jogo.getPontos());
            System.out.println("Tentativas usadas: " + jogo.getTentativas());

        } catch (TentativaEsgotadaException e) {
            System.out.println("\n--- FIM DE JOGO ---");
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("Pontuação final: " + jogo.getPontos());
        } finally {
            scanner.close();
        }
    }

    private static int[] lerEntrada(Scanner scanner, Jogo jogo, int numeroPeca) {
        while (true) {
            try {
                System.out.print("Escolha a " + numeroPeca + "ª peça (linha e coluna, ex: 1 2): ");
                int linha = scanner.nextInt() - 1;
                int coluna = scanner.nextInt() - 1;
                scanner.nextLine();

                Tabuleiro tab = jogo.getTabuleiro();
                if (linha < 0 || linha >= tab.getLINHAS() || coluna < 0 || coluna >= tab.getCOLUNAS()) {
                    System.out.println("Entrada inválida.");
                    continue;
                }

                Peca peca = tab.getPeca(linha, coluna);
                if (peca.isEncontrada() || peca == jogo.getPecaSelecionada1()) {
                    System.out.println("Entrada inválida.");
                    continue;
                }

                return new int[]{linha, coluna};
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            }
        }
    }

    public static void imprimirTabuleiro(Jogo jogo) {
        System.out.println("\n--------------------");
        System.out.println("Pontos: " + jogo.getPontos() + " | Tentativas: " + jogo.getTentativas());

        Tabuleiro tabuleiro = jogo.getTabuleiro();

        for (int i = 0; i < tabuleiro.getLINHAS(); i++) {
            for (int j = 0; j < tabuleiro.getCOLUNAS(); j++) {
                Peca peca = tabuleiro.getPeca(i, j);

                if (peca.isVisivel() || peca.isEncontrada())
                    System.out.print(peca.getValor() + "   ");
                else
                    System.out.print("?   ");

            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}