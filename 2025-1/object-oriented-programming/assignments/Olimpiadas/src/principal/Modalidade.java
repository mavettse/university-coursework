package principal;

public class Modalidade {
    private int limiteMembros;
    private String descricao;

    public Modalidade(int limiteMembros, String descricao) {
        this.limiteMembros = limiteMembros;
        this.descricao = descricao;
    }

    public Modalidade() {
        limiteMembros = 0;
        descricao = "";
    }

    public Modalidade(Modalidade modalidade){
        this.limiteMembros = modalidade.getLimiteMembros();
        this.descricao = modalidade.getDescricao();
    }

    public int getLimiteMembros() {
        return limiteMembros;
    }

    public void setLimiteMembros(int limiteMembros) {
        this.limiteMembros = limiteMembros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
