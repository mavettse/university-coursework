package principal;

public class PFisica extends Contribuinte{
    private String cpf;

    public PFisica(String nome, double rendaBruta, String cpf){
        super(nome, rendaBruta);
        this.cpf = cpf;
    }

}
