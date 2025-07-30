package principal;

import java.util.ArrayList;

public class Espaco2D {
    private ArrayList<Forma> formas;

    public Espaco2D(){
        formas = new ArrayList<>();
    }

    public Espaco2D(ArrayList<Forma> formas){
        this.formas = new ArrayList<>(formas);
    }

    public double calcularAreaTotal(){
        double area = 0;
        for(Forma temp : formas)
            area += temp.calcularArea();
        return area;
    }

    public double calcularPerimetroTotal(){
        double perimetro = 0;
        for(Forma forma : formas)
            perimetro += forma.calcularPerimetro();
        return perimetro;
    }

    public boolean adicionarForma(Forma forma){
        formas.add(forma);
        return formas.contains(forma);
    }

    public String mostrarTipoTriangulo(){
        StringBuilder tipos = new StringBuilder();
        for(Forma forma : formas)
            if(forma instanceof Triangulo)
                tipos.append(((Triangulo) forma).tipoTriangulo()).append("\n");
        if(tipos.isEmpty())
            return "Não há nenhum triângulo";
        return tipos.toString();
    }
}
