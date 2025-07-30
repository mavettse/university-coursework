package principal.controle;

import principal.modelo.CaracterInvalidoException;
import principal.modelo.ModeloConversor;
import principal.modelo.Moeda;
import principal.modelo.ValorNaoInformadoException;
import principal.visao.VisaoJanela;

import java.util.Map;

public class ControleConversor {
    private ModeloConversor modelo;
    private VisaoJanela visao;

    public ControleConversor(ModeloConversor modelo, VisaoJanela visao){
        this.modelo = modelo;
        this.visao = visao;

        configurarListeners();
    }

    public void iniciar(){
        this.visao.setVisible(true);
    }

    private void configurarListeners(){
        visao.addConverterListener(e -> executarConversao());
        visao.addLimparListener(e -> executarLimpeza());
    }

    private void executarConversao(){
        VisaoJanela.EntradaUsuario entradaUsuario;

        try{
            entradaUsuario = visao.getValorDigitado();
        } catch (ValorNaoInformadoException e) {
            System.err.println(e.getMessage());
            return;
        } catch (CaracterInvalidoException e) {
            visao.exibirMensagemErro();
            return;
        }

        Map<Moeda, Double> moedas = modelo.converter(entradaUsuario.valor(), entradaUsuario.moedaOrigem());

        visao.exibirResultados(moedas.get(Moeda.REAL), moedas.get(Moeda.DOLAR), moedas.get(Moeda.EURO));
    }

    private void executarLimpeza(){
        visao.limparCampos();
    }

}
