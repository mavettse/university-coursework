package principal;

public class EquacaoSegundoGrau {
    
    public double[] calcularRaizes(double a, double b, double c){
        if(a == 0)
            throw new IllegalArgumentException("Nao eh uma equacao do segundo grau");
        
        double delta = (b*b) - (4*a*c);
        double[] raiz;
        
        if(delta > 0){
            raiz = new double[2];
            raiz[0] = (-b + Math.sqrt(delta))/(2*a);
            raiz[1] = (-b - Math.sqrt(delta))/(2*a);
        } else if(delta == 0){
            raiz = new double[1];
            raiz[0] = -b/(2*a);
        } else {
            raiz = new double[0];
        }
        
        return raiz;
    }       
}
