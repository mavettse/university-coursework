package principal;

public class CifraDeCesar {
    private Chave chave;
    private String mensagemCifrada;

    public CifraDeCesar(Chave chave, String mensagemCifrada) {
        this.chave = new Chave(chave);
        this.mensagemCifrada = mensagemCifrada;
    }

    public CifraDeCesar(Chave chave) {
        this.chave = new Chave(chave);
        this.mensagemCifrada = "";
    }

    public String cifrarMensagem(String mensagem){
        StringBuilder retorno = new StringBuilder();

        for(int i = 0; i < mensagem.length(); ++i){
            String letra = String.valueOf(mensagem.charAt(i));
            if(letra.equals(" ")) {
                retorno.append(" ");
                continue;
            }
            retorno.append(chave.getLetraCifrada(chave.buscarIndice(letra)));
        }
        mensagemCifrada = retorno.toString();
        return retorno.toString();
    }

    public String decifrarMensagem(){
        StringBuilder retorno = new StringBuilder();

        for(int i = 0; i < mensagemCifrada.length(); ++i){
            String letra = String.valueOf(mensagemCifrada.charAt(i));
            if(letra.equals(" ")) {
                retorno.append(" ");
                continue;
            }
            retorno.append(chave.getLetraDecifrada(chave.buscarIndice(letra)));
        }

        return retorno.toString();
    }

    public String verificarMensagem(String mensagem) throws DecifragemInvalidaException {
        if(mensagemCifrada.isEmpty())
            return "Não existe nenhuma mensagem cifrada armazenada.";

        if (!decifrarMensagem().equals(mensagem))
            throw new DecifragemInvalidaException("Mensagem incorreta! Tente novamente");

        return "Mensagem correta!";
    }

    public Chave getChave() {
        return new Chave(chave);
    }

    public void setChave(Chave chave) {
        this.chave = new Chave(chave);
    }

    public String getMensagemCifrada() {
        return mensagemCifrada;
    }

    public void setMensagemCifrada(String mensagemCifrada) {
        this.mensagemCifrada = mensagemCifrada;
    }
}
