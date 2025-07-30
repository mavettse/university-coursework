package principal;

public abstract class Empregado implements Passivo {
    protected String nome;
    protected String sobrenome;
    protected int numIdent;
    protected int diaPgto;
    protected int mesPgto;

    public Empregado(String nome, String sobrenome, int numIdent, int diaPgto, int mesPgto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numIdent = numIdent;
        this.diaPgto = diaPgto;
        this.mesPgto = mesPgto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getNumIdent() {
        return numIdent;
    }

    public void setNumIdent(int numIdent) {
        this.numIdent = numIdent;
    }

    public int getDiaPgto() {
        return diaPgto;
    }

    public void setDiaPgto(int diaPgto) {
        this.diaPgto = diaPgto;
    }

    public int getMesPgto() {
        return mesPgto;
    }

    public void setMesPgto(int mesPgto) {
        this.mesPgto = mesPgto;
    }
}
