package negocio;

public class ContatoInexistenteException extends Exception{
    public ContatoInexistenteException(){
        super("O contato não existe");
    }
}
