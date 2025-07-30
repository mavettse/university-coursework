package principal;

import java.util.ArrayList;

public class Quadrado extends Forma{
    private double lado;

    public Quadrado(ArrayList<Ponto2D> pontos){
        this.pontos = new ArrayList<>(pontos);

        double temp = pontos.get(0).calcularDistancia(pontos.get(1));
        double temp2 = pontos.get(0).calcularDistancia(pontos.get(2));

        lado = Math.min(temp, temp2);
    }

    public double calcularArea(){
        return Math.pow(lado,2);
    }

    public double calcularPerimetro(){
        return lado*4;
    }

    public double getLado() {
        return lado;
    }
}
