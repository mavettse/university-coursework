package principal;

import java.util.ArrayList;
import java.util.Arrays; // Para facilitar a criação de ArrayLists

public class Teste {

    public static void main(String[] args) {

        System.out.println("--- Criando Temas de Decoração ---");

        ArrayList<String> itensCinderela = new ArrayList<>(Arrays.asList("Sapatinho de Cristal", "Carruagem Abóbora", "Vestido Azul Cintilante"));
        ItemDeDecoracao temaCinderela = new ItemDeDecoracao(itensCinderela, 150.00, "Azul Claro");
        System.out.println("Tema Criado: Cinderela");
        System.out.println("Itens da Cinderela:");
        for (String item : temaCinderela.getItens()) {
            System.out.println("- " + item);
        }
        System.out.println("Valor do aluguel: R$" + temaCinderela.getValorAluguel());
        System.out.println("Cor da toalha: " + temaCinderela.getCorToalha());
        System.out.println();

        ArrayList<String> itensBruxa = new ArrayList<>(Arrays.asList("Caldeirão Fumegante", "Vassoura Voadora", "Chapéu Pontudo"));
        ItemDeDecoracao temaBruxa = new ItemDeDecoracao(itensBruxa, 120.50, "Roxa Escura");
        System.out.println("Tema Criado: Bruxa");
        System.out.println("Itens da Bruxa:");
        System.out.println();

        ItemDeDecoracao temaCastelo = new ItemDeDecoracao();
        temaCastelo.setCorToalha("Dourada");
        temaCastelo.setValorAluguel(200.00);
        ArrayList<String> itensDoCastelo = new ArrayList<>(Arrays.asList("Miniatura do Castelo", "Bandeiras Medievais", "Cavaleiros de Brinquedo"));
        temaCastelo.setItens(itensDoCastelo);
        System.out.println("Tema Criado: Castelo");
        System.out.println("Itens do Castelo:");
        for (String item : temaCastelo.getItens()) {
            System.out.println("- " + item);
        }
        System.out.println();


        System.out.println("--- Criando Clientes ---");
        Cliente clienteAna = new Cliente("Ana Silva", 988776655);
        Cliente clienteJoao = new Cliente("João Pereira", 911223344);
        System.out.println("Cliente Criado: " + clienteAna.getNome() + ", Tel: " + clienteAna.getTelefone());
        System.out.println("Cliente Criado: " + clienteJoao.getNome() + ", Tel: " + clienteJoao.getTelefone());
        System.out.println();

        System.out.println("--- Criando Festas ---");
        Festa festa1 = new Festa(clienteAna, "Rua das Flores, 123", temaCinderela, "15/12/2024", "14:00", "18:00");
        System.out.println("Festa 1 Criada:");
        System.out.println("Cliente: " + festa1.getCliente().getNome());
        System.out.println("Tema da Festa 1: " + festa1.getTema().getCorToalha());
        System.out.println("Itens do Tema da Festa 1:");
        for (String item : festa1.getTema().getItens()) {
            System.out.println("- " + item);
        }
        System.out.println();

        Festa festa2 = new Festa();
        festa2.setCliente(clienteJoao);
        festa2.setEndereco("Avenida Principal, 789");
        festa2.setTema(temaBruxa);
        festa2.setData("20/01/2025");
        festa2.setHoraInicio("19:00");
        festa2.setHoraFinal("23:00");

        System.out.println("\nFesta 2 Criada:");
        System.out.println("Cliente: " + festa2.getCliente().getNome());
        System.out.println("Endereço: " + festa2.getEndereco());
        System.out.println("Tema da Festa 2 (cor da toalha): " + festa2.getTema().getCorToalha());
        System.out.println("Itens do Tema da Festa 2:");
        for (String item : festa2.getTema().getItens()) {
            System.out.println("- " + item);
        }
        System.out.println();
    }
}