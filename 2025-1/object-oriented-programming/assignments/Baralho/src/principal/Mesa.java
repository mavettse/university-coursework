package principal;

import java.util.Scanner;

public class Mesa {
    public static void main(String[] Args){
        boolean jogarNovamente = true;
        Scanner scanner = new Scanner(System.in);
        
        while(jogarNovamente){
            Baralho baralho = new Baralho();
            baralho.embaralhar();
            System.out.println("Mesa embaralhando...");
            
            System.out.print("Informe o numero de cartas a distribuir para os jogadores: ");
            int numeroCartas = scanner.nextInt();
            Jogador a = new Jogador(numeroCartas);
            Jogador b = new Jogador(numeroCartas);
            a.setMao(baralho.distribuirCartas(numeroCartas));
            b.setMao(baralho.distribuirCartas(numeroCartas));
            System.out.println("Mesa distribui " + numeroCartas + " cartas para jogador A e para jogador B");
            
            a.encontrarMaior();
            b.encontrarMaior();
            System.out.println("Jogador A joga " + a.getMaior().toString());
            System.out.println("Jogador B joga " + b.getMaior().toString());
            
            String naipeA = a.getMaior().getNaipe(); // variaveis auxiliares
            String naipeB = b.getMaior().getNaipe();
            int valorA = a.getMaior().getValor();
            int valorB = b.getMaior().getValor();
            
            String resultado =
                valorA > valorB ?
                    "O jogador A venceu o jogo." : 
                valorA < valorB ?
                    "O jogador B venceu o jogo." : 
                naipeA.equals("Ouros") && !naipeB.equals("Ouros") ? // se os dois jogadores possuem as maiores cartas com valores iguais
                    "O jogador A venceu o jogo." : 
                !naipeA.equals("Ouros") && naipeB.equals("Ouros") ?
                    "O jogador B venceu o jogo." :
                    "Como os valores das cartas sao iguais e nenhum jogador tem carta de Ouros, o jogo ficou empatado!";
            System.out.println(resultado);
            
            System.out.println("Deseja jogar novamente?\n1. Sim\n2. Nao");
            if(scanner.nextInt() == 1)
                System.out.println("Jogando novamente...");
            else {
                System.out.println("Finalizando...");
                jogarNovamente = false;
            }
        }
    }
}
