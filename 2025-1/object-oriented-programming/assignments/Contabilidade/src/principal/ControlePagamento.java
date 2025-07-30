package principal;

import java.util.ArrayList;

public class ControlePagamento {
    private ArrayList<Passivo> pagamentos;

    public ControlePagamento(ArrayList<Passivo> pagamentos) {
        this.pagamentos = (pagamentos == null ? new ArrayList<>() : new ArrayList<>(pagamentos));
    }

    public ControlePagamento() {
        pagamentos = new ArrayList<>();
    }

    public void adicionarPagamento(Passivo pagamento){
        if(pagamento == null)
            return;
        pagamentos.add(pagamento);
    }

    public double calcularValorEmpregados(){
        double total = 0;

        if(!pagamentos.isEmpty())
            for(Passivo aux : pagamentos)
                if(aux instanceof Empregado)
                    total += aux.getValorAPagar(((Empregado) aux).getDiaPgto(), ((Empregado) aux).getMesPgto());

        return total;
    }

    public double calcularValorEmpregados(int mes){
        double total = 0;

        if(!pagamentos.isEmpty())
            for(Passivo aux : pagamentos)
                if(aux instanceof Empregado)
                    if(((Empregado)aux).getMesPgto() == mes)
                        total += aux.getValorAPagar(((Empregado) aux).getDiaPgto(), ((Empregado) aux).getMesPgto());

        return total;
    }

    public double calcularValorContas(){
        double total = 0;

        if(!pagamentos.isEmpty())
            for (Passivo aux : pagamentos)
                if(aux instanceof Conta)
                    total += aux.getValorAPagar(((Conta) aux).getDia(), ((Conta) aux).getMes());

        return total;
    }

    public double calcularValorContas(int mes){
        double total = 0;

        if(!pagamentos.isEmpty())
            for (Passivo aux : pagamentos)
                if(aux instanceof Conta)
                    if(((Conta)aux).getMes() == mes)
                        total += aux.getValorAPagar(((Conta) aux).getDia(), ((Conta) aux).getMes());

        return total;
    }

    public double calcularValorTotal(){
        return calcularValorContas() + calcularValorEmpregados();
    }

    public double calcularValorTotal(int mes){
        return calcularValorContas(mes) + calcularValorEmpregados(mes);
    }

    public void exibirRelatorioPagamentosMensal(int mes){
        System.out.printf("---- PAGAMENTOS DO MÊS %d ----\nContas: R$ %.2f\nEmpregados: R$ %.2f\nTotal: R$ %.2f\n\n",
                mes, calcularValorContas(mes), calcularValorEmpregados(mes), calcularValorTotal(mes));
    }

    public ArrayList<Passivo> getPagamentos() {
        return new ArrayList<>(pagamentos);
    }

    public void setPagamentos(ArrayList<Passivo> pagamentos) {
        this.pagamentos = new ArrayList<>(pagamentos);
    }
}
