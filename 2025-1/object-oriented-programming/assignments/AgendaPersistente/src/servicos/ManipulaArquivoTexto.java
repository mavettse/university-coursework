package servicos;

import negocio.Contato;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ManipulaArquivoTexto {
    private String arquivo;
    private Formatter gravador;
    private Scanner leitor;

    public ManipulaArquivoTexto(String arquivo) {
        this.arquivo = arquivo;
    }

    public ManipulaArquivoTexto() {
        this.arquivo = "agendaPessoal.txt";
    }

    public void abrirArquivoParaGravacao(){
        try{
            gravador = new Formatter(new File(arquivo));
        } catch (FileNotFoundException e){
            System.err.println("O arquivo " + arquivo + " não pôde ser criado.");
        } catch (SecurityException e){
            System.err.println("O arquivo " + arquivo + " não possui permissão para gravar.");
        }
    }

    public void gravarContato(HashMap<String, Contato> contatos){
        Set<String> chaves = contatos.keySet();
        for(String chave : chaves){
            Contato contato = contatos.get(chave);
            gravador.format("%s;%s;%s;%s%n",
                    contato.getNome(),
                    contato.getTelefone(),
                    contato.getEndereco(),
                    contato.getEmail());
        }
    }

    public void fecharArquivoParaGravacao(){
        if(gravador != null)
            gravador.close();
    }

    public void abrirArquivoParaLeitura(){
        try{
            leitor = new Scanner(new File(arquivo));
        } catch(FileNotFoundException e) {
            System.err.println("Não foi possível abrir o arquivo " + arquivo + " para leitura.");}
    }

    public ArrayList<Contato> lerArquivo(){
        ArrayList<Contato> contatos = new ArrayList<>();
        if(leitor != null)
            while(leitor.hasNext()){
                String linha = leitor.nextLine();
                String[] campos = linha.split(";");
                if(campos.length == 4){
                    Contato contato = new Contato(campos[0], campos[1], campos[2], campos[3]);
                    contatos.add(contato);
                }

            }
        return contatos;
    }

    public void fecharArquivoLeitura(){
        if(leitor != null)
            leitor.close();
    }
}
