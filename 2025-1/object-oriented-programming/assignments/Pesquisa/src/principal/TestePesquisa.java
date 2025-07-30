package principal;

public class TestePesquisa {
    public static void main(String[] args) {
        // Criando uma população de exemplo
        Populacao[] habitantes = {
            new Populacao("feminino", "verdes", "louros", 25),
            new Populacao("feminino", "azuis", "louros", 30),
            new Populacao("masculino", "verdes", "pretos", 40),
            new Populacao("feminino", "verdes", "louros", 18),
            new Populacao("nao-binario", "castanhos", "castanhos", 22),
            new Populacao("feminino", "verdes", "louros", 35),
            new Populacao("feminino", "verdes", "pretos", 28)
        };

        // Instanciando a pesquisa
        Pesquisa pesquisa = new Pesquisa(habitantes);

        // Testando a maior idade
        System.out.println("Maior idade: " + pesquisa.maiorIdade() + " anos");

        // Testando a porcentagem de mulheres (18-35 anos, olhos verdes, cabelos louros)
        System.out.printf("Porcentagem específica: %.2f%%\n", pesquisa.calcularPorcentagemMVL());
    }
}