package principal;

public class Contribuinte {
    private String nome;
    private double rendaBruta;

    public Contribuinte(String nome, double rendaBruta) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
    }

    public String getNome(){
        return nome;
    }

    public double getRendaBruta() {
        return rendaBruta;
    }
    public double calcImposto(){
        double imposto = 0;
        if(rendaBruta <= 1400)
            return imposto;
        else if(rendaBruta <= 2100)
            imposto = (rendaBruta-1400)*0.1;
        else if(rendaBruta <= 2800)
            imposto = ((2100-1400.01)*0.1) + ((rendaBruta-2100)*0.15);
        else if(rendaBruta <= 3600)
            imposto = ((2100-1400.01)*0.1) + ((2800-2100.01)*0.15) + ((rendaBruta-2800)*0.25);
        else
            imposto = ((2100-1400.01)*0.1) + ((2800-2100.01)*0.15) + ((3600-2800.01)*0.25) + ((rendaBruta-3600)*0.3);
        return imposto;
    }
}
