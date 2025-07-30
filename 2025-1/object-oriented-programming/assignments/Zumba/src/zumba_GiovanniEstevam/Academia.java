package zumba_GiovanniEstevam;

import java.util.List;

public class Academia {
    private List<Turma> turmas;

    public Academia(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void cadastrarTurma(Turma turma){
        if(turma != null)
            turmas.add(turma);
    }

    public String listarTurmasComVagas(){
        StringBuilder turmasComVagas = new StringBuilder();
        for(Turma turma : turmas)
            if(turma.temVaga())
                turmasComVagas.append("Turma de " + turma.getDias().getDias() + " no horário de " + turma.getHorario() +
                        "\n");

        if(turmasComVagas.isEmpty())
            return "Não há turmas com vagas";
        return turmasComVagas.toString();
    }
}
