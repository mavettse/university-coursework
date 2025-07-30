package principal;

public class Populacao {
    private String genero;
    private String olhos;
    private String cabelo;
    private int idade;
    
    public Populacao(String genero, String olhos, String cabelo, int idade){
        this.genero = genero;
        this.olhos = olhos;
        this.cabelo = cabelo;
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
