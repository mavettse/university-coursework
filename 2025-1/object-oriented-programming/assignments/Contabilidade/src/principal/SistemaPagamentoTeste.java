package principal;

public class SistemaPagamentoTeste {
    public static void main(String[] args) {
        ControlePagamento controle = new ControlePagamento();

        Assalariado emp1 = new Assalariado("Ana", "Silva", 1, 5, 6, 45);
        Comissionado emp2 = new Comissionado("Carlos", "Souza", 2, 10, 6, 5000);
        AssalariadoComissionado emp3 = new AssalariadoComissionado("Beatriz", "Lima", 3, 15, 7, 8000, 0.1);
        Terceirizado emp4 = new Terceirizado("João", "Pereira", 4, 20, 6, 60);

        Concessionaria conta1 = new Concessionaria(8, 6, 300);
        Titulo conta2 = new Titulo(12, 6, 1000);

        controle.adicionarPagamento(emp1);
        controle.adicionarPagamento(emp2);
        controle.adicionarPagamento(emp3);
        controle.adicionarPagamento(emp4);
        controle.adicionarPagamento(conta1);
        controle.adicionarPagamento(conta2);

        controle.exibirRelatorioPagamentosMensal(6);
        controle.exibirRelatorioPagamentosMensal(7);
    }
}