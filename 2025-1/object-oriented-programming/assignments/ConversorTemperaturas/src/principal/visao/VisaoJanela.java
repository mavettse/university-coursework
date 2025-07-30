package principal.visao;

import principal.modelo.CaracterInvalidoException;
import principal.modelo.Temperatura;
import principal.modelo.ValorNaoInformadoException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Map;

public class VisaoJanela extends JFrame {
    private JPanel painelPrincipal;
    private JButton botaoConverter;
    private JButton botaoLimpar;
    private JTextField textCelsius;
    private JTextField textFahrenheit;
    private JTextField textKelvin;
    private JLabel celsius;
    private JLabel fahrenheit;
    private JLabel kelvin;
    private JPanel labels;
    private JPanel painelConversoes;
    private JPanel textos;
    private JPanel painelBotoes;

    public VisaoJanela(){
        setContentPane(painelPrincipal);
        setTitle("Conversor de Temperaturas");
        setSize(350,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void exibirMensagemErro(){
        JOptionPane.showMessageDialog(null, "Informe apenas números!", "Erro de Conversão", JOptionPane.ERROR_MESSAGE);
    }

    public void limparEntradas(){
        textCelsius.setText("");
        textFahrenheit.setText("");
        textKelvin.setText("");
    }

    public void exibirResultado(Map<Temperatura, String> resultado){
        textCelsius.setText(resultado.get(Temperatura.CELSIUS));
        textFahrenheit.setText(resultado.get(Temperatura.FAHRENHEIT));
        textKelvin.setText(resultado.get(Temperatura.KELVIN));
    }

    public EntradaUsuario getEntradas() throws CaracterInvalidoException, ValorNaoInformadoException {
        try{
            if(!textCelsius.getText().trim().isEmpty()){
                Double valor = Double.parseDouble(textCelsius.getText().trim());
                return new EntradaUsuario(Temperatura.CELSIUS, valor);
            }
            if(!textFahrenheit.getText().trim().isEmpty()){
                Double valor = Double.parseDouble(textFahrenheit.getText().trim());
                return new EntradaUsuario(Temperatura.FAHRENHEIT, valor);
            }
            if(!textKelvin.getText().trim().isEmpty()){
                Double valor = Double.parseDouble(textKelvin.getText().trim());
                return new EntradaUsuario(Temperatura.KELVIN, valor);
            }
        }
        catch(NumberFormatException e){
            throw new CaracterInvalidoException();
        }

        throw new ValorNaoInformadoException();
    }

    public void addListenerLimpar(ActionListener botaoLimparListener){
        botaoLimpar.addActionListener(botaoLimparListener);
    }

    public void addListenerConverter(ActionListener botaoConverterListener){
        botaoConverter.addActionListener(botaoConverterListener);
    }

    public record EntradaUsuario(Temperatura temperaturaOrigem, double valor){};

}


