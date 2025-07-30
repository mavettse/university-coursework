package principal;

import java.util.ArrayList;

public class DelegacaoOlimpica {
    private ArrayList<Modalidade> modalidades;
    private ArrayList<MembroComite> delegacao;
    private static final int LIMITE_PROFISSIONAIS_SAUDE = 10;

    public DelegacaoOlimpica(ArrayList<Modalidade> modalidades, ArrayList<MembroComite> delegacao) {
        this.modalidades = modalidades;
        this.delegacao = delegacao;
    }

    public DelegacaoOlimpica() {
        modalidades = new ArrayList<>();
        delegacao = new ArrayList<>();
    }

    public boolean adicionarMembro(MembroComite membro){
        if(membro == null)
            return false;

        if(membro instanceof Tecnico || membro instanceof Atleta){
            Modalidade modalidade;

            if(membro instanceof Tecnico)
                modalidade = ((Tecnico) membro).getModalidade();
            else modalidade = ((Atleta) membro).getModalidade();

            if(modalidade == null){
                System.out.println("O membro não está associado a nenhuma modalidade.");
                return false;
            }

            if(!modalidades.contains(modalidade)) {
                System.out.println("A delegação olímpica não possui essa modalidade.");
                return false;
            }

            if(contarMembrosPorModalidade(modalidade) >= modalidade.getLimiteMembros()){
                System.out.println("Limite máximo de membros atingido.");
                return false;
            }
        } else if(membro instanceof ProfissionalSaude){
            if(contarProfissionaisSaude() >= LIMITE_PROFISSIONAIS_SAUDE){
                System.out.println("Limite máximo de profissionais de saúde atingido.");
                return false;
            }
        } else {
            System.out.println("Tipo de membro desconhecido não pode ser adicionado");
            return false;
        }
        delegacao.add(membro);
        return true;
    }

    private int contarAtletas(MembroComite membro){
        if(delegacao.isEmpty() || !(membro instanceof Atleta))
            return 0;

        Atleta atleta = (Atleta)membro;
        Modalidade modalidade = atleta.getModalidade();

        if(modalidade == null)
            return 0;

        int contador = 0;
        for(MembroComite aux : delegacao)
            if(aux instanceof Atleta) {
                Atleta temp = (Atleta)aux;
                if(modalidade.equals(temp.getModalidade()))
                    contador++;
            }

        return contador;
    }

    private int contarTecnicos(MembroComite membro){
        if(delegacao.isEmpty() || !(membro instanceof Tecnico))
            return 0;

        Tecnico tecnico = (Tecnico)membro;
        Modalidade modalidade = tecnico.getModalidade();

        if(modalidade == null)
            return 0;

        int contador = 0;
        for(MembroComite aux : delegacao)
            if(aux instanceof Tecnico){
                Tecnico temp = (Tecnico)aux;
                if(modalidade.equals(temp.getModalidade()));
                contador++;
            }

        return contador;
    }

    private int contarMembrosPorModalidade(Modalidade modalidade){
        if(modalidade == null || modalidades.isEmpty())
            return 0;

        int contador = 0;
        for(MembroComite aux : delegacao){
            if(aux instanceof Atleta){
                Atleta temp = (Atleta) aux;
                if(modalidade.equals(temp.getModalidade()))
                    contador++;
            } else if(aux instanceof Tecnico){
                Tecnico temp = (Tecnico) aux;
                if(modalidade.equals(temp.getModalidade()))
                    contador++;
            }
        }

        return contador;
    }

    private int contarProfissionaisSaude(){
        int contador = 0;
        for(MembroComite aux : delegacao){
            if(aux instanceof ProfissionalSaude)
                contador++;
        }
        return contador;
    }

    public boolean adicionarModalidade(Modalidade modalidade){
        if(modalidade == null || modalidade.getDescricao() == null || modalidade.getDescricao().isEmpty())
            return false;

        for (Modalidade aux : modalidades) {
            if (aux.getDescricao().equals(modalidade.getDescricao())) {
                System.out.println("A modalidade já existe.");
                return false;
            }
        }

        modalidades.add(modalidade);
        return true;
    }

    public ArrayList<Modalidade> getModalidades() {
        return new ArrayList<>(modalidades);
    }

    public void setModalidades(ArrayList<Modalidade> modalidades) {
        this.modalidades = new ArrayList<>(modalidades);
    }

    public ArrayList<MembroComite> getDelegacao() {
        return new ArrayList<>(delegacao);
    }

    public void setDelegacao(ArrayList<MembroComite> delegacao) {
        this.delegacao = new ArrayList<>(delegacao);
    }
}
