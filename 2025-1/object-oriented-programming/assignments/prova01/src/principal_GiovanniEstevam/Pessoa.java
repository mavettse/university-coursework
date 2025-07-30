package principal_GiovanniEstevam;

public class Pessoa {
    private String nome;
    private String cpf;
    private String contato;

    public Pessoa(String nome, String cpf, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContato() {
        return contato;
    }
}
