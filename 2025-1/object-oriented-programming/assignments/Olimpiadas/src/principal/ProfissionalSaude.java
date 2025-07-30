package principal;

public class ProfissionalSaude extends MembroComite{
    private String especialidade;

    public ProfissionalSaude(String nome, String genero, int idade, String especialidade) {
        super(nome, genero, idade);
        this.especialidade = especialidade;
    }

    public ProfissionalSaude(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String exibirDados() {
        return nome + " | " + especialidade + "\n";
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
