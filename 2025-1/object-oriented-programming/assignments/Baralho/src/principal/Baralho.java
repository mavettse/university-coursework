package principal;

import java.security.SecureRandom;

public class Baralho {
    private final Carta[] cartas;
    private final String[] naipes = {"Ouros", "Copas", "Espadas", "Paus"};
    private final SecureRandom gerador;
    
    public static final int AS = 1;
    public static final int VALETE = 11;
    public static final int DAMA = 12;
    public static final int REI = 13;
    
    public Baralho(){
        cartas = new Carta[52]; // definindo o tamanho da array
        gerador = new SecureRandom();
        int aux = 0; 
        for(String naipe : naipes) // dois loops para inicializar as 13 cartas de cada um dos 4 naipes
            for(int j = AS; j < REI; ++j)
                cartas[aux++] = new Carta(naipe, j);
    }
    
    public void embaralhar(){ // algoritmo de fisher-yates
        for(int i = cartas.length - 1; i > 0; --i){
            int temp = gerador.nextInt(i + 1);
            Carta aux = cartas[i];
            cartas[i] = cartas[temp];
            cartas[temp] = aux;
        }
    }
    
    public Carta[] distribuirCartas(int tamanho){ 
        if(tamanho < 0)
            throw new IllegalArgumentException("O numero de cartas precisa ser positivo");
        if(tamanho > cartas.length/2)
            throw new IllegalArgumentException("Nao ha cartas o suficiente para distribuir");
           
        Carta[] dealer = new Carta[tamanho];
        
        for(int i = 0; i < tamanho; ++i) 
            for(int j = 0; j < cartas.length; ++j)
                if(cartas[j] != null){
                    dealer[i] = cartas[j];
                    cartas[j] = null;
                    break;
                }
        
        return dealer;
    }
    
}
