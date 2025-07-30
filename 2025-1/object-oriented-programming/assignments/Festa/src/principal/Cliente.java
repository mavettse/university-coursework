package principal;

public class Cliente {
    private String nome;
    private int telefone;

    public Cliente(String nome, int telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Cliente(Cliente cliente){
        nome = cliente.getNome();
        telefone = cliente.getTelefone();
    }

    public Cliente() {
        nome = "";
        telefone = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
