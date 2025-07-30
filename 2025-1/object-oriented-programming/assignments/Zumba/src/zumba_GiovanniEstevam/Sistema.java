package zumba_GiovanniEstevam;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Aluno a = new Aluno("Giovanni Estevam");
        Aluno b = new Aluno("Wescley Navarro");
        Aluno c = new Aluno("João Pedro Lopes");
        Aluno d = new Aluno("Luciana Gomes");
        Aluno e = new Aluno("Mara Cristina");

        ArrayList<Aluno> alunosTurmaA = new ArrayList<>();
        ArrayList<Aluno> alunosTurmaB = new ArrayList<>();
        ArrayList<Aluno> alunosTurmaC = new ArrayList<>();
        ArrayList<Aluno> alunosTurmaD = new ArrayList<>();
        ArrayList<Aluno> alunosTurmaE = new ArrayList<>();

        for(int i = 0; i < 15; ++i){
            alunosTurmaA.add(a);
            alunosTurmaB.add(b);
            alunosTurmaC.add(c);
            alunosTurmaD.add(d);
            alunosTurmaE.add(e);
        }

        DiasSemana seg_qua = new DiasSemana("Seg - Qua");
        DiasSemana ter_qui = new DiasSemana("Ter - Qui");

        Turma turmaA = new Turma(alunosTurmaA, seg_qua, "11:00");
        Turma turmaB = new Turma(alunosTurmaB, seg_qua, "13:00");
        Turma turmaC = new Turma(alunosTurmaC, seg_qua, "15:00");
        Turma turmaD = new Turma(alunosTurmaD, seg_qua, "17:00");
        Turma turmaE = new Turma(alunosTurmaE, seg_qua, "19:00");

        Turma turmaF = new Turma(new ArrayList<>(), ter_qui, "11:00");
        Turma turmaG = new Turma(new ArrayList<>(), ter_qui, "13:00");
        Turma turmaH = new Turma(new ArrayList<>(), ter_qui, "15:00");
        Turma turmaI = new Turma(new ArrayList<>(), ter_qui, "17:00");
        Turma turmaJ = new Turma(new ArrayList<>(), ter_qui, "19:00");

        List<Turma> listaTurmas = new ArrayList<>();
        listaTurmas.add(turmaA);
        listaTurmas.add(turmaB);
        listaTurmas.add(turmaC);
        listaTurmas.add(turmaD);
        listaTurmas.add(turmaE);
        listaTurmas.add(turmaF);
        listaTurmas.add(turmaG);
        listaTurmas.add(turmaH);
        listaTurmas.add(turmaI);
        listaTurmas.add(turmaJ);

        Academia academia = new Academia(listaTurmas);

        System.out.println("Turmas com vagas:");
        System.out.println(academia.listarTurmasComVagas());

        try {
            turmaA.matricularAluno(new Aluno("Novo Aluno"));
        } catch (TurmaCompletaException ex) {
            System.out.println("Erro ao matricular em turmaA: " + ex.getMessage());
        }

        try {
            turmaF.matricularAluno(new Aluno("Aluno Livre"));
            System.out.println("Aluno matriculado com sucesso na turmaF!");
        } catch (TurmaCompletaException ex) {
            System.out.println("Erro ao matricular em turmaF: " + ex.getMessage());
        }
    }
}