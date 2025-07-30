package principal;

import java.util.HashMap;

public class Sala {
    private int numero;
    private int capacidade;
    private HashMap<String, Bilhete> assentos;

    public Sala(int numero, int capacidade){
        this.numero = numero;
        this.capacidade = capacidade;
        assentos = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public HashMap<String, Bilhete> getAssentos() {
        return assentos;
    }
}
