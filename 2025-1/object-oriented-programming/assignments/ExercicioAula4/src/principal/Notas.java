package principal;

import java.security.SecureRandom;
import java.util.Arrays;

public class Notas {
    private final int[] vetor;
    private final SecureRandom gerador;
    private static final int TAMANHO_VETOR = 10;
    
    public Notas(){
        vetor = new int[TAMANHO_VETOR];
        gerador = new SecureRandom();
    }
    
    public void teste(){
        for(int i = 0; i < vetor.length; ++i) // declarando todos os 10 elementos do array como zero
            vetor[i] = 0;
        
        for(int i = 0, j = 0; j < 40; i+=2, j++)
            vetor[i%10] += gerador.nextInt(10);
        System.out.println("Vetor após adições: " + Arrays.toString(vetor));
        
        int maior = vetor[0];
        int quantidade = 0;
        
        for(int i : vetor)
            if(maior < i)
                maior = i;
        
        for(int i : vetor)
            if(maior == i)
                quantidade++;
        
        int[] pos = new int[quantidade];
        int aux = 0;
        
        for(int i = 0; i < vetor.length; ++i)
            if(maior == vetor[i])
                pos[aux++] = i;
        
        System.out.println("O maior valor do vetor eh " + maior + " nas posicoes " + Arrays.toString(pos));
    }
    
}
