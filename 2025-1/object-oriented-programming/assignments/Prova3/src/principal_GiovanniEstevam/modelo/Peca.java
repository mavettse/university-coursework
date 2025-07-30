package principal_GiovanniEstevam.modelo;

public class Peca {
    private int valor;
    private boolean visivel;
    private boolean encontrada;

    public Peca(int valor){
        this.valor = valor;
        visivel = false;
        encontrada = false;
    }

    public Peca(){
        valor = 0;
        visivel = false;
        encontrada = false;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public boolean isEncontrada() {
        return encontrada;
    }

    public void setEncontrada(boolean encontrada) {
        this.encontrada = encontrada;
    }
}
