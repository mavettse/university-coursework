package principal;

public class Pesquisa {
    private final Populacao[] populacao;
    
    public Pesquisa(Populacao[] populacao){
        this.populacao = populacao;
    }
    
    public int maiorIdade(){
        int maior = 0;
        for(Populacao aux : populacao)
            if(aux.getIdade() > maior)
                maior = aux.getIdade();
        return maior;
    }
    
    public double calcularPorcentagemMVL(){
        int total = 0, indiv = 0;
        for(Populacao aux : populacao){
            total++;
            if("feminino".equals(aux.getGenero()) && "verdes".equals(aux.getOlhos()) && "louros".equals(aux.getCabelo()) && aux.getIdade() >= 18 && aux.getIdade() <= 35)
                indiv++;
        }
        if(total != 0)
            return (indiv*100.0) / total;
        else return 0;
    }
    
}
