package principal;

public class Filme {
    private String titulo;
    private String genero;
    private int ano;
    private String diretor;
    private Sala sala;

    public Filme(String titulo, String genero, int ano, String diretor, Sala sala) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.diretor = diretor;
        this.sala = sala;
    }

    public String getTitulo() {
        return titulo;
    }

    public Sala getSala() {
        return sala;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Gênero: " + genero + " | Diretor: " + diretor + " | Sala: " + sala + '\n';
    }
}
