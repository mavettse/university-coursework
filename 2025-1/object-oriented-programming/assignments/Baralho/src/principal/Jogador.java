package principal;

public class Jogador {
    private Carta[] mao;
    private Carta maior;

    public Jogador(int tamanho){
        if(tamanho < 0)
            throw new IllegalArgumentException("Tamanho da mao nao pode ser negativo");
        mao = new Carta[tamanho];
    }
    
    public Carta encontrarMaior(){
        if(mao == null || mao[0] == null || mao.length == 0)
            throw new IllegalArgumentException("A mao do jogador esta vazia ou nao foi inicializada");
        
        maior = mao[0];
        
        for(int i = 1; i < mao.length; ++i)
            if(maior.ehMaior(mao[i]) == -1) // mao[i] é maior
                maior = mao[i];
            else if(maior.ehMaior(mao[i]) == 0 && mao[i].getNaipe().equals("Ouros") && !maior.getNaipe().equals("Ouros"))
                maior = mao[i];
        
        return maior;
    }
    
    public void mostrarMao(){
        System.out.print("Mao: ");
        if(mao == null)
            System.out.println("[Vazia]");
        for(Carta aux : mao)
            System.out.print((aux!= null ? aux.toString() : "[Vazio]") + " | ");
        System.out.println();
    }
    
    public void setMao(Carta[] cartasDistribuidas){
        mao = cartasDistribuidas;
        maior = null;
    }

    public Carta getMaior(){
        return maior;
    }
    
}
