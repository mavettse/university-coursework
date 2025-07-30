package principal;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Bilhete bilhete = new Bilhete(28);
        Maquina maquina = new Maquina();

        Sala sala1 = new Sala(1, 20);
        Sala sala2 = new Sala(2, 20);
        maquina.adicionarSala(sala1);
        maquina.adicionarSala(sala2);

        Filme filme1 = new Filme("Premonição 6: Laços de Sangue", "Terror", 2025, "Zach Lipovsky", sala1);
        Filme filme2 = new Filme("Interestelar", "Sci-Fi", 2014, "Christopher Nolan", sala2);
        maquina.adicionarFilme(filme1);
        maquina.adicionarFilme(filme2);

        boolean loop = true;
        Scanner leitor = new Scanner(System.in);

        while (loop) {
            System.out.println("1. Cliente" + '\n' + "2. Funcionário" + '\n' + "3. Sair");
            int opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    boolean opcaoCliente = true;
                    while (opcaoCliente) {
                        System.out.println("O que você deseja fazer?" + '\n' +
                                "1. Consultar filmes em exibição" + '\n' +
                                "2. Comprar ingressos" + '\n' +
                                "3. Sair");
                        int cliente = leitor.nextInt();
                        switch (cliente) {
                            case 1:
                                System.out.println(maquina.consultarFilmes());
                                break;
                            case 2:
                                System.out.println("Selecione o número do filme:");
                                for (int i = 0; i < maquina.getFilmes().size(); i++) {
                                    System.out.println((i + 1) + ". " + maquina.getFilmes().get(i).toString());
                                }
                                int filmeEscolhido = leitor.nextInt() - 1;
                                if (filmeEscolhido >= 0 && filmeEscolhido < maquina.getFilmes().size()) {
                                    System.out.println("Quantos ingressos deseja comprar?");
                                    int quantidade = leitor.nextInt();
                                    maquina.comprarIngresso(maquina.getFilmes().get(filmeEscolhido), quantidade);
                                } else {
                                    System.out.println("Filme inválido.");
                                }
                                break;
                            case 3:
                                opcaoCliente = false;
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;
                case 2:
                    boolean opcaoFuncionario = true;
                    while (opcaoFuncionario) {
                        System.out.println("O que você deseja fazer?" + '\n' +
                                "1. Adicionar sala" + '\n' +
                                "2. Adicionar filme" + '\n' +
                                "3. Informar valor dos ingressos" + '\n' +
                                "4. Sair");
                        int funcionario = leitor.nextInt();
                        switch (funcionario) {
                            case 1:
                                System.out.println("Informe o número da sala:");
                                int numeroSala = leitor.nextInt();
                                System.out.println("Informe a capacidade da sala:");
                                int capacidadeSala = leitor.nextInt();
                                maquina.adicionarSala(new Sala(numeroSala, capacidadeSala));
                                break;
                            case 2:
                                System.out.println("Informe o nome do filme:");
                                leitor.nextLine(); // Consumir quebra de linha
                                String nomeFilme = leitor.nextLine();
                                System.out.println("Informe o gênero do filme:");
                                String generoFilme = leitor.nextLine();
                                System.out.println("Informe o ano do filme:");
                                int anoFilme = leitor.nextInt();
                                System.out.println("Informe o diretor do filme:");
                                leitor.nextLine(); // Consumir quebra de linha
                                String diretorFilme = leitor.nextLine();
                                System.out.println("Informe o número da sala:");
                                int salaFilme = leitor.nextInt();
                                Sala sala = null;
                                for (Sala s : maquina.getSalas()) {
                                    if (s.getNumero() == salaFilme) {
                                        sala = s;
                                        break;
                                    }
                                }
                                if (sala != null) {
                                    maquina.adicionarFilme(new Filme(nomeFilme, generoFilme, anoFilme, diretorFilme, sala));
                                } else {
                                    System.out.println("Sala não encontrada.");
                                }
                                break;
                            case 3:
                                System.out.println("Informe o novo valor dos ingressos:");
                                double novoValor = leitor.nextDouble();
                                maquina.alterarValorBilhete(novoValor);
                                break;
                            case 4:
                                opcaoFuncionario = false;
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        leitor.close();
    }
}
