package principal;

import java.util.ArrayList;


public class Circulo extends Forma {
    private double raio;
    private static final double EPSILON = 1e-6;

    public Circulo(ArrayList<Ponto2D> pontos){
        if(pontos.get(0).calcularDistancia(pontos.get(1)) < EPSILON)
            throw new IllegalArgumentException("Pontos para o círculo são coincidentes, resultando em raio zero.");
        this.pontos = new ArrayList<>(pontos);
        raio = pontos.get(0).calcularDistancia(pontos.get(1));
    }

    public double calcularArea() {
        return Math.PI*Math.pow(raio,2);
    }

    public double calcularPerimetro(){
        return 2*Math.PI*raio;
    }

    public double getRaio() {
        return raio;
    }
}
