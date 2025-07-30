package principal.visao;

import principal.modelo.CaracterInvalidoException;
import principal.modelo.Moeda;
import principal.modelo.ValorNaoInformadoException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class VisaoJanela extends JFrame {
    private JPanel painelPrincipal;
    private JButton botaoConverter;
    private JButton botaoLimpar;
    private JTextField textReal;
    private JTextField textDolar;
    private JTextField textEuro;
    private JLabel Real;
    private JLabel Dolar;
    private JLabel Euro;
    private JPanel Labels;
    private JPanel painelConversoes;
    private JPanel Textos;
    private JPanel painelBotoes;

    public VisaoJanela(){
        setContentPane(painelPrincipal);
        setTitle("Conversor de moedas");
        this.pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public EntradaUsuario getValorDigitado() throws CaracterInvalidoException, ValorNaoInformadoException{
        try {
            if(!textReal.getText().trim().isEmpty()) {
                double valor = Double.parseDouble(textReal.getText().trim());
                return new EntradaUsuario(valor, Moeda.REAL);
            }
            if(!textDolar.getText().trim().isEmpty()) {
                double valor = Double.parseDouble(textDolar.getText().trim());
                return new EntradaUsuario(valor, Moeda.DOLAR);
            }
            if(!textEuro.getText().trim().isEmpty()) {
                double valor = Double.parseDouble(textEuro.getText().trim());
                return new EntradaUsuario(valor, Moeda.DOLAR);
            }

            throw new ValorNaoInformadoException();

        } catch (NumberFormatException e) {
            throw new CaracterInvalidoException();
        }
    }

    public void exibirResultados(double real, double dolar, double euro){
        String sReal = String.format(Moeda.REAL.getSimbolo() + " %.2f", real);
        String sDolar = String.format(Moeda.DOLAR.getSimbolo() + " %.2f", dolar);
        String sEuro = String.format(Moeda.EURO.getSimbolo() + " %.2f", euro);

        textReal.setText(sReal);
        textDolar.setText(sDolar);
        textEuro.setText(sEuro);
    }

    public void limparCampos(){
        textReal.setText("");
        textDolar.setText("");
        textEuro.setText("");
    }

    public void exibirMensagemErro(){
        JOptionPane.showMessageDialog(null, "Informe apenas números!", "Erro de Conversão", JOptionPane.ERROR_MESSAGE);
    }

    public void addConverterListener(ActionListener listener){
        botaoConverter.addActionListener(listener);
    }

    public void addLimparListener(ActionListener listener){
        botaoLimpar.addActionListener(listener);
    }

    public record EntradaUsuario(double valor, Moeda moedaOrigem){};

}


