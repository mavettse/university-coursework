package principal;

public class TesteQuestao1 {
    public static Contribuinte[] contribuinte;
    public static int indice = 0;

    public static void main(String[] args) {
        contribuinte = new Contribuinte[5];

        Contribuinte[] pessoas = {
                new PFisica("Vitória Pereira de Oliveira", 3600, "123.456.789-10"),
                new PFisica("Gabriel Gomes Silveira", 2500, "019.876.543-10"),
                new PFisica("Dorival Fernandes Silva", 1200, "65432198710"),
                new PJuridica("Epa", 600000000, "66644488810"),
                new PFisica("Robson Lima Rodrigues", 15000, "98353428319")
        };

        for(Contribuinte pessoa : pessoas)
            addContribuinte(pessoa);

        System.out.println("NOME                 IMPOSTO\n");
        System.out.println("============================\n\n");

        for(Contribuinte aux : contribuinte)
            System.out.printf("%-20s %9.2f\n", aux.getNome(), aux.calcImposto());
    }

    public static void addContribuinte(Contribuinte novo) {
        contribuinte[indice] = novo;
        indice++;
    }
}
