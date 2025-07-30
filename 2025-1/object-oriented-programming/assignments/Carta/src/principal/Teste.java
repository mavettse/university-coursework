package principal;

public class Teste {
    public static void main(String[] Args){
        Carta c1 = new Carta("paus", 4);
        Carta c2 = new Carta("paus", 9);
        Carta c3 = new Carta("ouros", 4);
                
        System.out.println("----COMPARANDO VALORES----");
        switch(c1.comparaValor(c2)){
            case 1 -> System.out.println("c1 eh maior que c2");
            case 0 -> System.out.println("c1 eh igual a c2");
            case -1 -> System.out.println("c1 eh menor que c2");
        }
        switch(c1.comparaValor(c3)){
            case 1 -> System.out.println("c1 eh maior que c3");
            case 0 -> System.out.println("c1 eh igual a c3");
            case -1 -> System.out.println("c1 eh menor que c3");
        }
        
        System.out.println("----COMPARANDO NAIPES----");
        if(c1.comparaNaipe(c2) == 1)
           System.out.println("c1 tem o mesmo naipe de c2");
        else
            System.out.println("c1 tem naipe diferente de c2");
        if(c1.comparaNaipe(c3) == 1)
           System.out.println("c1 tem o mesmo naipe de c3");
        else
            System.out.println("c1 tem naipe diferente de c3");
        
    }
    
}