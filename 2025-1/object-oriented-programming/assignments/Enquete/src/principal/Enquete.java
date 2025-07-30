package principal;

import java.util.ArrayList;
import java.util.HashMap;

public class Enquete {
    private ArrayList<Nota> notas;

    public Enquete() {
        notas = new ArrayList<>();
    }

    public Enquete(ArrayList<Nota> notas){
        this.notas = new ArrayList<>(notas);
    }

    public String frequenciaNotas(){
        if(notas.isEmpty())
            return "Não há nenhuma nota";

        HashMap<Integer, Integer> frequencia = new HashMap<>();
        for(int i = 0; i <= 10; ++i)
            frequencia.put(i,0);

        for(Nota aux : notas)
            frequencia.put(aux.getNota(), frequencia.get(aux.getNota()) + 1);

        StringBuilder saida = new StringBuilder();
        for(int i = 0; i <= 10; ++i)
            saida.append(String.format("Nota: %d | Frequência: %d\n", i, frequencia.get(i)));

        return saida.toString();
    }

    public double mediaNotas(){
        if(notas.isEmpty())
            return 0;

        double aux = 0;
        for(Nota temp : notas)
            aux += temp.getNota();

        return aux/notas.size();
    }

    public int alunosEntrevistados(){
        return notas.size();
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
}
