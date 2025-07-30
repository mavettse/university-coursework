package principal;

public class Principal {
    public static void main(String[] args) {
        Lampada l1 = new Lampada(
            Lampada.EstadoLampada.APAGADA,
            0,
            Lampada.TipoLampada.COMUM
        );

        Lampada l2 = new Lampada(
            Lampada.EstadoLampada.APAGADA,
            0,
            Lampada.TipoLampada.AJUSTAVEL
        );

        System.out.println("---- Lâmpada COMUM ----");
        l1.ajustarLuminosidade(100);
        System.out.println("Estado: " + l1.getEstado());
        System.out.println("Luminosidade: " + l1.getLuminosidade());

        l1.ajustarLuminosidade(30);
        System.out.println("Estado: " + l1.getEstado());
        System.out.println("Luminosidade: " + l1.getLuminosidade());

        l1.ajustarLuminosidade(0);
        System.out.println("Estado: " + l1.getEstado());
        System.out.println("Luminosidade: " + l1.getLuminosidade());

        System.out.println("\n---- Lâmpada AJUSTÁVEL ----");
        l2.ajustarLuminosidade(75);
        System.out.println("Estado: " + l2.getEstado());
        System.out.println("Luminosidade: " + l2.getLuminosidade());

        l2.ajustarLuminosidade(0);
        System.out.println("Estado: " + l2.getEstado());
        System.out.println("Luminosidade: " + l2.getLuminosidade());

        System.out.println("\n---- Testando Lâmpada QUEIMADA ----");
        l2.ajustarLuminosidade(100);
        System.out.println("Antes de queimar:");
        System.out.println("Estado: " + l2.getEstado());
        System.out.println("Luminosidade: " + l2.getLuminosidade());

        l2.queimar();
        l2.ajustarLuminosidade(100);
        System.out.println("Depois de queimar:");
        System.out.println("Estado: " + l2.getEstado());
        System.out.println("Luminosidade: " + l2.getLuminosidade());
    }
}
