package principal;

public class Atleta extends MembroComite{
    private Modalidade modalidade;

    public Atleta(String nome, String genero, int idade, Modalidade modalidade) {
        super(nome, genero, idade);
        this.modalidade = modalidade;
    }

    public Atleta(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String exibirDados() {
        return nome + " | " + modalidade.getDescricao() + " | Atleta\n";
    }

    public Modalidade getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
