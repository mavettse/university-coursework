package principal_GiovanniEstevam;

public class TesteUber {
    public static void main(String[] args) {
        Cefet cefet = new Cefet();

        Motorista motorista1 = new Motorista("Cláudio Menezes", "123456789", "claudinhomenezes@gmail.com");
        Motorista motorista2 = new Motorista("Pedro Gonzales", "987654321", "pedrinhogonzales@gmail.com");

        Veiculo veiculo1 = new Veiculo(motorista1, "Kwid", "ABC123");
        Veiculo veiculo2 = new Veiculo(motorista2, "Hb20", "FALL3N1");

        Cliente cliente1 = new Cliente("Fernanda Gomes", "654987321", "fernandinha123@gmail.com", 2200);
        Cliente cliente2 = new Cliente("Karla Camila", "78531895", "karlinhacamila@gmail.com", 1500);

        Corrida corrida1carro1 = new Corrida(cefet, veiculo1, cliente1, 5000);
        System.out.printf("Faturamento CEFET corrida 1:\n%.2f\n", corrida1carro1.getValorCorrida()*0.3);
        Corrida corrida2carro1 = new Corrida(cefet, veiculo1, cliente2, 2000);
        System.out.printf("Faturamento CEFET corrida 2:\n%.2f\n", corrida2carro1.getValorCorrida()*0.3);
        Corrida corrida3carro1 = new Corrida(cefet, veiculo1, cliente1, 6200);
        System.out.printf("Faturamento CEFET corrida 3:\n%.2f\n", corrida3carro1.getValorCorrida()*0.3);

        Corrida corrida1carro2 = new Corrida(cefet, veiculo2, cliente2, 3000);
        System.out.printf("Faturamento CEFET corrida 4:\n%.2f\n", corrida1carro2.getValorCorrida()*0.3);
        Corrida corrida2carro2 = new Corrida(cefet, veiculo2, cliente1, 4444);
        System.out.printf("Faturamento CEFET corrida 5:\n%.2f\n", corrida2carro2.getValorCorrida()*0.3);
        Corrida corrida3carro2 = new Corrida(cefet, veiculo2, cliente2, 18000);
        System.out.printf("Faturamento CEFET corrida 6:\n%.2f\n\n", corrida3carro2.getValorCorrida()*0.3);

        System.out.printf("Faturamento total do CEFET:\nR$ %.2f\n\nFaturamento total do carro 1:\nR$ %" +
                ".2f\n\nFaturamento total do carro 2:\nR$ %.2f\n\n", cefet.getFaturamento(), motorista1.getFaturamento(), motorista2.getFaturamento());

    }
}
