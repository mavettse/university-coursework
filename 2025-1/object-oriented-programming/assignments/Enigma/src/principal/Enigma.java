package principal;

import java.util.Scanner;

public class Enigma {
    public static void main(String[] args) {
        Chave chave1 = new Chave(4);
        CifraDeCesar cifra = new CifraDeCesar(chave1);

        cifra.cifrarMensagem("estevam lindao");

        Scanner entrada = new Scanner(System.in);
        Boolean loop = true;

        while(loop){
            exibirMenu();
            int escolha = entrada.nextInt();
            entrada.nextLine();
            switch(escolha){
                case 1:
                    System.out.println("Mensagem Cifrada: " + cifra.getMensagemCifrada());
                    System.out.println("Deslocamento: " + cifra.getChave().getDeslocamento());
                    System.out.print("Sua tentativa: ");
                    try {
                        String resultado = cifra.verificarMensagem(entrada.nextLine());
                        System.out.println(resultado);
                        loop = false;
                    } catch (DecifragemInvalidaException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Fechando o aplicativo...");
                    entrada.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("\nDeseja tentar acertar a mensagem cifrada?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Escolha uma opção: ");
    }
}
