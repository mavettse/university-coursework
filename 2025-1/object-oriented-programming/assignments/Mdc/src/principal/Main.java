package principal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] numeros = new int[2];
        Scanner numero = new Scanner(System.in);
        
        System.out.println("Digite dois numeros:");
        numeros[0] = numero.nextInt();
        numeros[1] = numero.nextInt();
        
        Mdc MDC = new Mdc(numeros);
        
        System.out.println("O MDC eh = " + MDC.calcularMDC());
    }
}