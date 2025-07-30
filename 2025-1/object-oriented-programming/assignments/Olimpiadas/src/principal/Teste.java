package principal;

public class Teste {
    public static void main(String[] args) {

        DelegacaoOlimpica delegacaoBrasil = new DelegacaoOlimpica();

        Modalidade judo = new Modalidade(2, "Judô");
        Modalidade skate = new Modalidade(5, "Skate");
        Modalidade natacao = new Modalidade(10, "Natação");

        delegacaoBrasil.adicionarModalidade(judo);
        delegacaoBrasil.adicionarModalidade(skate);
        delegacaoBrasil.adicionarModalidade(natacao);

        Atleta atletaJudo1 = new Atleta("Rafaela Silva", "Feminino", 30, judo);
        Tecnico tecnicoJudo1 = new Tecnico("Fulano de Tal", "Masculino", 45, "Técnico Principal", judo);
        Atleta atletaJudo2 = new Atleta("Daniel Cargnin", "Masculino", 25, judo);


        System.out.println(delegacaoBrasil.adicionarMembro(atletaJudo1) ? "OK" : "FALHA");
        System.out.println(delegacaoBrasil.adicionarMembro(tecnicoJudo1) ? "OK" : "FALHA");
        System.out.println(delegacaoBrasil.adicionarMembro(atletaJudo2) ? "OK" : "FALHA");

        Atleta atletaSkate1 = new Atleta("Rayssa Leal", "Feminino", 15, skate);
        Atleta atletaSkate2 = new Atleta("Kelvin Hoefler", "Masculino", 29, skate);

        System.out.println(delegacaoBrasil.adicionarMembro(atletaSkate1) ? "OK" : "FALHA");
        System.out.println(delegacaoBrasil.adicionarMembro(atletaSkate2) ? "OK" : "FALHA");

        ProfissionalSaude medico = new ProfissionalSaude("Dr. House", "Masculino", 50, "Clínico Geral");
        ProfissionalSaude fisioterapeuta = new ProfissionalSaude("Dra. Grey", "Feminino", 40, "Fisioterapeuta Esportiva");

        System.out.println(delegacaoBrasil.adicionarMembro(medico) ? "OK" : "FALHA");
        System.out.println(delegacaoBrasil.adicionarMembro(fisioterapeuta) ? "OK" : "FALHA");

        System.out.println("\nMembros do Comitê:");
        for(MembroComite membro : delegacaoBrasil.getDelegacao())
            System.out.print(membro.exibirDados());
    }
}