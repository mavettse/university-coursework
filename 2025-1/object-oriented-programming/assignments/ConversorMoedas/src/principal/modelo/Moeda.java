package principal.modelo;

public enum Moeda {
    REAL("Real", "R$"),
    DOLAR("Dólar", "$"),
    EURO("Euro", "€");

    private String nomeExibicao;
    private String simbolo;

    private Moeda(String nomeExibicao, String simbolo){
        this.nomeExibicao = nomeExibicao;
        this.simbolo = simbolo;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public String getSimbolo() {
        return simbolo;
    }

}
