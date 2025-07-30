package principal;

import java.util.ArrayList;

public abstract class Forma {
    protected ArrayList<Ponto2D> pontos;

    public Forma() {
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public static Forma gerarForma(ArrayList<Ponto2D> pontos){
        if(pontos.size() == 2){
            Circulo circulo = new Circulo(pontos);
            return circulo;
        }
        if(pontos.size() == 3){
            Triangulo triangulo = new Triangulo(pontos);
            return triangulo;
        }
        if(pontos.size() == 4) {
            Quadrado quadrado = new Quadrado(pontos);
            return quadrado;
        }
        return null;
    }
}
