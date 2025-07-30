package principal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SecureRandom numAleatorio = new SecureRandom();

        System.out.println("Digite o número de alunos: ");
        int numAlunos = entrada.nextInt();
        if(numAlunos < 0)
            throw new IllegalArgumentException("Número inválido!");

        ArrayList<Nota> notas = new ArrayList<>();
        for(int i = 0; i < numAlunos; ++i){
            Nota nota = new Nota(numAleatorio.nextInt(11));
            notas.add(nota);
        }

        Enquete enquete = new Enquete(notas);

        System.out.printf("Frequência das notas:\n%s\n\nMédia das notas:\n%.2f\n\nAlunos entrevistados:\n%d\n",
                enquete.frequenciaNotas(), enquete.mediaNotas(), enquete.alunosEntrevistados());
    }
}
