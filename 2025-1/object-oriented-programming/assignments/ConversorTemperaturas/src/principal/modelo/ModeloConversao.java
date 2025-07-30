package principal.modelo;

import java.util.HashMap;
import java.util.Map;

public class ModeloConversao {
    public ModeloConversao(){
    }

    public Map<Temperatura, String> conversor(Temperatura temperaturaOrigem, double valor){
        double valorCelsius;

        switch(temperaturaOrigem){ //celsius será a temperatura pivô
            case CELSIUS: valorCelsius = valor; break;
            case FAHRENHEIT: valorCelsius = (valor - 32)/1.8; break;
            case KELVIN: valorCelsius = valor - 273; break;
            default: throw new IllegalArgumentException("Temperatura de origem desconhecida");
        }

        String valorFahrenheit = String.valueOf((valorCelsius * 1.8) + 32);
        String valorKelvin = String.valueOf(valorCelsius + 273);

        Map<Temperatura, String> resultados = new HashMap<>();

        resultados.put(Temperatura.CELSIUS, String.valueOf(valorCelsius));
        resultados.put(Temperatura.FAHRENHEIT, valorFahrenheit);
        resultados.put(Temperatura.KELVIN, valorKelvin);

        return resultados;
    }



}
