package principal;

import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de Suporte Técnico\nPressione <enter> para continuar ou digite 'sair' para sair do sistema.");

        String aux = scan.nextLine();
        if(aux.equalsIgnoreCase("sair"))
            return;

        SuporteTecnico suporte = new SuporteTecnico();
        Interpretadora interpretadora = new Interpretadora();
        boolean loop = true;

        while(loop){
            System.out.println("Descreva seu problema de maneira sucinta.");
            String temp = scan.nextLine();

            interpretadora.separarFrase(temp);
            System.out.println(suporte.buscaSolucao(interpretadora.getPalavrasChave()));

            System.out.println("Pressione <enter> para continuar ou digite 'sair' para sair do sistema.");
            String temp2 = scan.nextLine();
            if(temp2.equalsIgnoreCase("sair")){
                System.out.println("Obrigado por utilizar nossos serviços!");
                loop = false;
            }

        }
    }
}
