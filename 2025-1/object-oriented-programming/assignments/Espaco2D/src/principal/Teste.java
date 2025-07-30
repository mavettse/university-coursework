package principal;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        Espaco2D meuEspaco = new Espaco2D();

        ArrayList<Ponto2D> pontosCirculo1 = new ArrayList<>();
        pontosCirculo1.add(new Ponto2D(0, 0));
        pontosCirculo1.add(new Ponto2D(3, 0));

        ArrayList<Ponto2D> pontosTrianguloEquilatero = new ArrayList<>();
        Ponto2D t1_p1 = new Ponto2D(10, 0);
        Ponto2D t1_p2 = new Ponto2D(14, 0);
        Ponto2D t1_p3 = new Ponto2D(12, 2 * Math.sqrt(3));
        pontosTrianguloEquilatero.add(t1_p1);
        pontosTrianguloEquilatero.add(t1_p2);
        pontosTrianguloEquilatero.add(t1_p3);

        ArrayList<Ponto2D> pontosTrianguloIsosceles = new ArrayList<>();
        Ponto2D t2_p1 = new Ponto2D(20, 5);
        Ponto2D t2_p2 = new Ponto2D(26, 5);
        Ponto2D t2_p3 = new Ponto2D(23, 9);
        pontosTrianguloIsosceles.add(t2_p1);
        pontosTrianguloIsosceles.add(t2_p2);
        pontosTrianguloIsosceles.add(t2_p3);

        ArrayList<Ponto2D> pontosTrianguloEscaleno = new ArrayList<>();
        pontosTrianguloEscaleno.add(new Ponto2D(0, 10));
        pontosTrianguloEscaleno.add(new Ponto2D(5, 10));
        pontosTrianguloEscaleno.add(new Ponto2D(3, 15));

        ArrayList<Ponto2D> pontosQuadrado1 = new ArrayList<>();
        pontosQuadrado1.add(new Ponto2D(30, 0));
        pontosQuadrado1.add(new Ponto2D(35, 0));
        pontosQuadrado1.add(new Ponto2D(30, 5));
        pontosQuadrado1.add(new Ponto2D(35, 5));

        Forma formaGerada;

        formaGerada = Forma.gerarForma(pontosCirculo1);
        if (formaGerada != null) {
            meuEspaco.adicionarForma(formaGerada);
            System.out.println("Círculo 1 criado e adicionado.");
        } else {
            System.out.println("Falha ao criar Círculo 1.");
        }

        formaGerada = Forma.gerarForma(pontosTrianguloEquilatero);
        if (formaGerada != null) {
            meuEspaco.adicionarForma(formaGerada);
            System.out.println("Triângulo Equilátero criado e adicionado.");
        } else {
            System.out.println("Falha ao criar Triângulo Equilátero.");
        }

        formaGerada = Forma.gerarForma(pontosTrianguloIsosceles);
        if (formaGerada != null) {
            meuEspaco.adicionarForma(formaGerada);
            System.out.println("Triângulo Isósceles criado e adicionado.");
        } else {
            System.out.println("Falha ao criar Triângulo Isósceles.");
        }

        formaGerada = Forma.gerarForma(pontosTrianguloEscaleno);
        if (formaGerada != null) {
            meuEspaco.adicionarForma(formaGerada);
            System.out.println("Triângulo Escaleno criado e adicionado.");
        } else {
            System.out.println("Falha ao criar Triângulo Escaleno.");
        }

        formaGerada = Forma.gerarForma(pontosQuadrado1);
        if (formaGerada != null) {
            meuEspaco.adicionarForma(formaGerada);
            System.out.println("Quadrado 1 criado e adicionado.");
        } else {
            System.out.println("Falha ao criar Quadrado 1.");
        }

        String tiposDeTriangulo = meuEspaco.mostrarTipoTriangulo();
        System.out.println("\n--- Tipos de Triângulo ---");
        System.out.println(tiposDeTriangulo);


        System.out.println("--- Cálculos Totais ---");
        double areaTotal = meuEspaco.calcularAreaTotal();
        double perimetroTotal = meuEspaco.calcularPerimetroTotal();

        System.out.printf("Área total de todas as formas: %.2f\n", areaTotal);
        System.out.printf("Perímetro total de todas as formas: %.2f\n", perimetroTotal);

    }
}