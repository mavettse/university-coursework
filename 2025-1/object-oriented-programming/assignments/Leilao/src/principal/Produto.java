package principal;

public class Produto {
    private String descricao;
    private Lance maiorLance;

    public Produto(String descricao) {
        this.descricao = descricao;
        maiorLance = new Lance();
    }

    public void verificarMaiorLance(Lance lance){
        if(lance.getValorLance() > maiorLance.getValorLance())
            maiorLance = lance;
    }

    public String getDescricao() {
        return descricao;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }
}
