package principal;

public class Carta {
    private final String naipe;
    private final int valor;

    public Carta(String naipe, int valor) {
        this.naipe = naipe;
        this.valor = valor;
    }
    
    public int ehMaior(Carta carta){
        if(this.valor > carta.getValor()) //se a carta de fora for maior que a carta de dentro
            return 1;
        else if (this.valor < carta.getValor()) // se a carta de fora for menor que a carta de dentro
            return -1; 
        return 0; // se as duas cartas forem iguais
    }
    
    @Override
    public String toString(){
        String nomeValor;
        nomeValor = switch (valor) {
            case 1 -> "As";
            case 11 -> "Valete";
            case 12 -> "Rainha";
            case 13 -> "Rei";
            default -> String.valueOf(valor);
        };
        return nomeValor + " de " + naipe;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getValor() {
        return valor;
    }

}
