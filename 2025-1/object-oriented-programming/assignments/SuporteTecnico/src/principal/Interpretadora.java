package principal;

import java.util.HashSet;

public class Interpretadora {
    private HashSet<String> palavrasChave;

    public Interpretadora(){
        palavrasChave = new HashSet<>();
    }

    public void separarFrase(String frase){
        if(frase == null)
            return;
        palavrasChave.clear();
        String[] palavrinhas = frase.split(" ");
        for(String aux : palavrinhas)
            adicionarPalavra(aux);
    }

    private void adicionarPalavra(String palavra){
        palavrasChave.add(palavra);
    }

    public String[] getPalavrasChave(){
        return palavrasChave.toArray(new String[0]);
    }
}
