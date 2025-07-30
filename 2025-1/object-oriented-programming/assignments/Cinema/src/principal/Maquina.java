package principal;

import java.util.ArrayList;
import java.util.HashMap;

public class Maquina {
    private ArrayList<Sala> salas;
    private ArrayList<Filme> filmes;
    private HashMap<Sala, Integer> cadeirasOcupadas;
    private Bilhete bilhete;

    public Maquina() {
        salas = new ArrayList<>();
        filmes = new ArrayList<>();
        cadeirasOcupadas = new HashMap<>();
        bilhete = new Bilhete(28);
    }

    public void adicionarSala(Sala sala) {
        for (Sala aux : salas)
            if (aux.getNumero() == sala.getNumero()) {
                System.out.println("Já existe uma sala com esse número");
                return;
            }

        salas.add(sala);
    }

    public void adicionarFilme(Filme filme) {
        if(!salas.contains(filme.getSala())) {
            System.out.println("Essa sala não existe");
            return;
        }

        for (Filme aux : filmes)
            if (aux.getSala() == filme.getSala()) {
                System.out.println("Essa sala já está ocupada");
                return;
            }

        filmes.add(filme);
    }

    public String consultarFilmes() {
        if (filmes.isEmpty())
            return "Não há nenhum filme em cartaz";

        StringBuilder emCartaz = new StringBuilder("Filmes em cartaz:\n");
        for (Filme aux : filmes)
            emCartaz.append(aux.toString());

        return emCartaz.toString();
    }

    public void comprarIngresso(Filme filme, int quantidade) {
        cadeirasOcupadas.putIfAbsent(filme.getSala(), 0);

        int total = cadeirasOcupadas.get(filme.getSala()) + quantidade;
        int capacidade = filme.getSala().getCapacidade();

        if (total > capacidade) {
            System.out.println("A sala está cheia");
            return;
        }

        double valorTotal = 0;

        for(int i = 0; i < quantidade; ++i){
            String temp = "" + (filme.getSala().getAssentos().size() + i + 1);
            valorTotal += bilhete.getValor();
            filme.getSala().getAssentos().put(temp, bilhete);
        }

        cadeirasOcupadas.put(filme.getSala(), total);

        System.out.printf("Cadeiras reservadas com sucesso!\nO valor total da compra é de R$ %.2f\n", valorTotal);

    }

    public void alterarValorBilhete(double novoValor){
        if(novoValor >= 0) {
            bilhete = new Bilhete(novoValor);
            System.out.println("Valor alterado com sucesso!");
        }
        else
            System.out.println("Valor inválido");
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public HashMap<Sala, Integer> getCadeirasOcupadas() {
        return cadeirasOcupadas;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }
}
