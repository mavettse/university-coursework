package principal;

public class Carta {
    private String naipe;
    private int valor;
    
    public int comparaValor(Carta carta){
        if(valor > carta.valor)
            return 1;
        else if(valor == carta.valor)
            return 0;
        return -1;
    }
    
    public int comparaNaipe(Carta carta){
        if(carta.naipe.equals(naipe))
            return 1;
        return 0;
    }
    
    public Carta(){
        naipe = "";
        valor = 0;
    }
    
    public Carta(String naipe, int valor){
        this.naipe = naipe;
        this.valor = valor;
    }
    
    public Carta(Carta carta){
        this.naipe = carta.naipe;
        this.valor = carta.valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getValor() {
        return valor;
    }
    
}
