package principal;

public class Pessoa {
    private String nome;
    private String contato;

    public Pessoa(){
        nome = "";
        contato = "";
    }

    public Pessoa(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}
