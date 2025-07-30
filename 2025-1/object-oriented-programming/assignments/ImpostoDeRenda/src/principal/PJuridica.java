package principal;

public class PJuridica extends Contribuinte{
    private String cnpj;

    public PJuridica(String nome, double rendaBruta, String cnpj){
        super(nome, rendaBruta);
        this.cnpj = cnpj;
    }

    public double calcImposto(){
        return getRendaBruta()*0.1;
    }
}
