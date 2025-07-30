package principal;

public class Nota {
    private int nota;

    public Nota(){
    }

    public Nota(int nota){
        if(nota < 0 || nota > 10)
            throw new IllegalArgumentException("A nota deve ser entre 0 e 10");
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }
}
