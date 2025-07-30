package principal_GiovanniEstevam.modelo;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int pontos;
    private int tentativas;
    private int paresEncontrados;
    private Peca pecaSelecionada1;
    private Peca pecaSelecionada2;

    public final int MAX_TENTATIVAS = 15;

    public Jogo(){
        tabuleiro = new Tabuleiro();
    }

    public void iniciarNovoJogo(){
        pontos = 0;
        tentativas = 0;
        paresEncontrados = 0;
        pecaSelecionada1 = null;
        pecaSelecionada2 = null;
        tabuleiro.embaralhar();
    }

    public void escolherPeca(int linha, int coluna) throws TentativaEsgotadaException {
        if (tentativas >= MAX_TENTATIVAS && !isVitoria())
            throw new TentativaEsgotadaException();

        Peca pecaEscolhida = tabuleiro.getPeca(linha, coluna);

        if(pecaEscolhida.isEncontrada() || pecaEscolhida == pecaSelecionada1) {
            return;
        }

        pecaEscolhida.setVisivel(true);

        if (pecaSelecionada1 == null)
            pecaSelecionada1 = pecaEscolhida;
        else if (pecaSelecionada2 == null) {
            pecaSelecionada2 = pecaEscolhida;
            verificarJogada();
        }
    }

    private void verificarJogada(){
        if(pecaSelecionada1.getValor() == pecaSelecionada2.getValor()){
            pecaSelecionada1.setEncontrada(true);
            pecaSelecionada2.setEncontrada(true);
            paresEncontrados++;
            pontos++;
        }

        tentativas++;

    }

    public void resetarJogadaIncorreta() {
        if (pecaSelecionada1 != null && !pecaSelecionada1.isEncontrada())
            pecaSelecionada1.setVisivel(false);

        if (pecaSelecionada2 != null && !pecaSelecionada2.isEncontrada())
            pecaSelecionada2.setVisivel(false);

        pecaSelecionada1 = null;
        pecaSelecionada2 = null;
    }

    public boolean isFimDeJogo(){
        return isVitoria() || tentativas >= MAX_TENTATIVAS;
    }

    public boolean isVitoria(){
        return paresEncontrados == 6;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public int getPontos() {
        return pontos;
    }

    public int getTentativas() {
        return tentativas;
    }

    public Peca getPecaSelecionada1() {
        return pecaSelecionada1;
    }

    public Peca getPecaSelecionada2() {
        return pecaSelecionada2;
    }
}