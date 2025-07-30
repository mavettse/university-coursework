package principal;

import principal.controle.ControleConversor;
import principal.modelo.ModeloConversor;
import principal.visao.VisaoJanela;

public class App {
    public static void main(String[] args) {
        VisaoJanela visao = new VisaoJanela();
        ModeloConversor modelo = new ModeloConversor();

        ControleConversor controle = new ControleConversor(modelo, visao);

        controle.iniciar();
    }

}
