package principal;

public class Tecnico extends MembroComite{
    private String atividade;
    private Modalidade modalidade;

    public Tecnico(String nome, String genero, int idade, String atividade, Modalidade modalidade) {
        super(nome, genero, idade);
        this.atividade = atividade;
        this.modalidade = modalidade;
    }

    public Tecnico(String atividade, Modalidade modalidade) {
        this.atividade = atividade;
        this.modalidade = modalidade;
    }

    public Tecnico(Tecnico tecnico){
        this.atividade = tecnico.getAtividade();
        this.modalidade = tecnico.getModalidade();
    }

    @Override
    public String exibirDados() {
        return nome + " | " + modalidade.getDescricao() + " | " + atividade + "\n";
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Modalidade getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
}
