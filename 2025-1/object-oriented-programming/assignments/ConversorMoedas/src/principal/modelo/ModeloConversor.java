package principal.modelo;

import java.util.HashMap;
import java.util.Map;

public class ModeloConversor {
    private final double cambioDolarReal = 5.48;
    private final double cambioEuroReal = 6.37;

    private final double cambioRealDolar = 1 / cambioDolarReal;
    private final double cambioRealEuro = 1 / cambioEuroReal;

    public ModeloConversor(){
    }

    public Map<Moeda, Double> converter(double valor, Moeda moedaOrigem) throws IllegalArgumentException{
        Map<Moeda, Double> conversao = new HashMap<>();

        double valorEmReal = 0; //real será a moeda pivô

        switch(moedaOrigem){
            case REAL:
                valorEmReal = valor; break;
            case DOLAR:
                valorEmReal = valor * cambioDolarReal; break;
            case EURO:
                valorEmReal = valor * cambioEuroReal; break;

            default: throw new IllegalArgumentException("Moeda de origem desconhecida: " + moedaOrigem.getNomeExibicao());
        }

        conversao.put(Moeda.REAL, valorEmReal);
        conversao.put(Moeda.DOLAR, valorEmReal * cambioRealDolar);
        conversao.put(Moeda.EURO, valorEmReal * cambioRealEuro);

        return new HashMap<>(conversao);
    }


}
