package negocio;

import servicos.ManipulaArquivoTexto;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Agenda {
    private HashMap<String,Contato> contatos;

    public Agenda(HashMap<String, Contato> contatos) {
        this.contatos = new HashMap<>(contatos);
    }

    public Agenda() {
        this.contatos = new HashMap<>();
    }

    public boolean incluirContato(Contato contato){
        if(contato == null)
            return false;

        String nome = contato.getNome();
        contatos.put(nome, contato);
        return true;
    }

    public boolean existeContato(String nome){
        if(nome == null)
            return false;

        return contatos.containsKey(nome);
    }

    public ArrayList<Contato> consultarContato(String nome) throws ContatoInexistenteException{
        if(nome == null)
            throw new ContatoInexistenteException();

        ArrayList<Contato> possiveisContatos = new ArrayList<>();
        for(Contato contato : contatos.values())
            if(contato.getNome().toLowerCase().startsWith(nome.toLowerCase()))
                possiveisContatos.add(contato);

        if(possiveisContatos.isEmpty())
            throw new ContatoInexistenteException();

        return possiveisContatos;
    }

    public void removerContato(String nome) throws ContatoInexistenteException{
        if(nome == null || !contatos.containsKey(nome))
            throw new ContatoInexistenteException();

        contatos.remove(nome);
    }

    public void persistirAgenda() {
        ManipulaArquivoTexto salvarAgenda = new ManipulaArquivoTexto();

        salvarAgenda.abrirArquivoParaGravacao();
        salvarAgenda.gravarContato(new HashMap<>(contatos));
        salvarAgenda.fecharArquivoParaGravacao();
    }

    public void lerAgenda(){
        ManipulaArquivoTexto lerAgenda = new ManipulaArquivoTexto();
        ArrayList<Contato> contatosLidos;

        lerAgenda.abrirArquivoParaLeitura();
        contatosLidos = lerAgenda.lerArquivo();
        lerAgenda.fecharArquivoLeitura();

        for(Contato contato : contatosLidos){
            contatos.put(contato.getNome(), contato);
        }
    }

    public HashMap<String, Contato> getContatos() {
        return new HashMap<>(contatos);
    }

    public void setContatos(HashMap<String, Contato> contatos) {
        this.contatos = new HashMap<>(contatos);
    }
}
