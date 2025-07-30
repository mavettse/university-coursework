package principal;

import principal.controle.ControleConversao;
import principal.modelo.ModeloConversao;
import principal.visao.VisaoJanela;

public class App {
    public static void main(String[] args) {
        VisaoJanela visao = new VisaoJanela();
        ModeloConversao modelo = new ModeloConversao();
        ControleConversao controle = new ControleConversao(visao, modelo);

        controle.iniciar();
    }
}
