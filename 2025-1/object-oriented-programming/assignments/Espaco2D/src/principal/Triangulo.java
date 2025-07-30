package principal;

import java.util.ArrayList;

public class Triangulo extends Forma{
    private double lado1;
    private double lado2;
    private double lado3;
    private static final double EPSILON = 1e-6;

    public Triangulo(ArrayList<Ponto2D> pontos){
        this.pontos = new ArrayList<>(pontos);

        lado1 = pontos.get(0).calcularDistancia(pontos.get(1));
        lado2 = pontos.get(0).calcularDistancia(pontos.get(2));
        lado3 = pontos.get(1).calcularDistancia(pontos.get(2));
    }

    public double calcularArea(){
        double sp = calcularPerimetro()/2;
        return Math.sqrt(sp*(sp-lado1)*(sp-lado2)*(sp-lado3));
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public String tipoTriangulo(){
        boolean l1l2 = Math.abs(lado1 - lado2) < EPSILON; //se verdadeiro, são iguais
        boolean l1l3 = Math.abs(lado1 - lado3) < EPSILON;
        boolean l2l3 = Math.abs(lado2 - lado3) < EPSILON;

        if(l1l2 && l1l3)
            return "Equilátero";
        if(l1l2 || l1l3 || l2l3)
            return "Isósceles";
        return "Escaleno";
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }
}
