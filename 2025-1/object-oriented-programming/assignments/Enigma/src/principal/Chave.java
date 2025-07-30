package principal;

import java.util.ArrayList;

public class Chave {
    int deslocamento;
    ArrayList<String> alfabeto;

    public Chave(int deslocamento) {
        this.deslocamento = deslocamento;
        this.alfabeto = new ArrayList<>();
        for(char letra = 'a'; letra <= 'z'; letra++)
            this.alfabeto.add(Character.toString(letra));
    }

    public Chave(Chave chave){
        this.deslocamento = chave.getDeslocamento();
        this.alfabeto = chave.getAlfabeto();
    }

    public int buscarIndice(String letra){
        if(letra == null || letra.length() > 1)
            throw new IllegalArgumentException("Digite uma letra");

        char ascii = letra.toLowerCase().charAt(0);
        if(ascii < 97 || ascii > 122)
            throw new IllegalArgumentException("Digite uma letra");

        return alfabeto.indexOf(letra.toLowerCase());
    }

    public String getLetraCifrada(int indice){
        int posicao = indice + deslocamento;
        return alfabeto.get(posicao%alfabeto.size());
    }

    public String getLetraDecifrada(int indice){
        int posicao = indice - deslocamento;
        if(posicao < 0)
            posicao += alfabeto.size();
        return alfabeto.get(posicao);
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public ArrayList<String> getAlfabeto() {
        return new ArrayList<>(alfabeto);
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = new ArrayList<>(alfabeto);
    }
}
