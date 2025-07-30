package zumba_GiovanniEstevam;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private ArrayList<Aluno> alunos;
    private DiasSemana dias;
    private String horario;
    private static final int CAPACIDADE_MAX = 15;

    public Turma(ArrayList<Aluno> alunos, DiasSemana dias, String horario) {
        this.alunos = alunos;
        this.dias = dias;
        this.horario = horario;
    }

    public void matricularAluno(Aluno aluno) throws TurmaCompletaException{
        if(!temVaga())
            throw new TurmaCompletaException();

        alunos.add(aluno);
    }

    public boolean temVaga(){
        return alunos.size() < CAPACIDADE_MAX;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public DiasSemana getDias() {
        return dias;
    }

    public void setDias(DiasSemana dias) {
        this.dias = dias;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
