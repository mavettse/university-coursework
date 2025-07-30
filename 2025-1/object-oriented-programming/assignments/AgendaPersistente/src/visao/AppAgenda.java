package visao;

import negocio.Agenda;
import negocio.Contato;
import negocio.ContatoInexistenteException;

import java.util.ArrayList;
import java.util.Scanner;

public class AppAgenda {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Agenda agenda = new Agenda();
        agenda.lerAgenda();

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Erro: Digite um número válido.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    incluirNovoContato(teclado, agenda);
                    break;
                case 2:
                    consultarUmContato(teclado, agenda);
                    break;
                case 3:
                    removerUmContato(teclado, agenda);
                    break;
                case 4:
                    listarTodosContatos(agenda);
                    break;
                case 0:
                    agenda.persistirAgenda();
                    System.out.println("Agenda salva. Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        teclado.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- AGENDA PESSOAL ---");
        System.out.println("1 - Incluir Contato");
        System.out.println("2 - Consultar Contato");
        System.out.println("3 - Remover Contato");
        System.out.println("4 - Listar Todos os Contatos");
        System.out.println("0 - Salvar e Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void incluirNovoContato(Scanner teclado, Agenda agenda) {
        System.out.println("\n--- Novo Contato ---");
        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        if (agenda.existeContato(nome)) {
            System.err.println("Erro: Já existe um contato com este nome.");
            return;
        }

        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();
        System.out.print("Endereço: ");
        String endereco = teclado.nextLine();
        System.out.print("E-mail: ");
        String email = teclado.nextLine();

        Contato novoContato = new Contato(nome, telefone, endereco, email);
        if (agenda.incluirContato(novoContato))
            System.out.println("Contato incluído com sucesso!");
        else
            System.err.println("Falha ao incluir o contato.");

    }

    private static void consultarUmContato(Scanner teclado, Agenda agenda) {
        System.out.print("\nDigite o nome (ou início do nome) do contato para consultar: ");
        String prefixo = teclado.nextLine();

        try {
            ArrayList<Contato> encontrados = agenda.consultarContato(prefixo);
            System.out.println("--- Contato(s) Encontrados ---");
            for (Contato c : encontrados) {
                System.out.println("------------------------");
                System.out.println("Nome: " + c.getNome());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("E-mail: " + c.getEmail());
                System.out.println(("Endereço: " + c.getEndereco()));
            }
            System.out.println("------------------------");
        } catch (ContatoInexistenteException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void removerUmContato(Scanner teclado, Agenda agenda) {
        System.out.print("\nDigite o nome do contato para remover: ");
        String nome = teclado.nextLine();

        try {
            agenda.removerContato(nome);
            System.out.println("Contato '" + nome + "' removido com sucesso.");
        } catch (ContatoInexistenteException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void listarTodosContatos(Agenda agenda) {
        System.out.println("\n--- Lista de Contatos ---");

        if (agenda.getContatos().isEmpty())
            System.out.println("A agenda está vazia.");
        else
            for (Contato contato : agenda.getContatos().values())
                System.out.printf("Nome: %-20s | Telefone: %s\n", contato.getNome(), contato.getTelefone());

        System.out.println("-------------------------");
    }
}