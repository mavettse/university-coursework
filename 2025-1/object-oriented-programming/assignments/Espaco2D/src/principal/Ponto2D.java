package principal;

public class Ponto2D {
    private double x;
    private double y;

    public Ponto2D() {
        x = 0;
        y = 0;
    }

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D ponto){
        x = ponto.getX();
        y = ponto.getY();
    }

    public double calcularDistancia(Ponto2D ponto){
        return Math.sqrt(Math.pow((x - ponto.getX()),2) + Math.pow((y - ponto.getY()),2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
