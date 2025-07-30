package principal.controle;

import principal.modelo.CaracterInvalidoException;
import principal.modelo.ModeloConversao;
import principal.modelo.ValorNaoInformadoException;
import principal.visao.VisaoJanela;

public class ControleConversao {
    private VisaoJanela visao;
    private ModeloConversao modelo;

    public ControleConversao(VisaoJanela visao, ModeloConversao modelo){
        this.visao = visao;
        this.modelo = modelo;

        configurarListeners();
    }

    public void configurarListeners(){
        visao.addListenerLimpar(e -> executarLimpar());
        visao.addListenerConverter(e -> executarConverter());
    }

    private void executarConverter(){
        VisaoJanela.EntradaUsuario entradaUsuario;

        try{
            entradaUsuario = visao.getEntradas();
        }
        catch(CaracterInvalidoException e){
            visao.exibirMensagemErro();
            return;
        }
        catch(ValorNaoInformadoException e){
            System.err.println(e.getMessage());
            return;
        }

        visao.exibirResultado(modelo.conversor(entradaUsuario.temperaturaOrigem(),
                entradaUsuario.valor()));

    }

    private void executarLimpar(){
        visao.limparEntradas();
    }

    public void iniciar(){
        visao.setVisible(true);
    }
}
