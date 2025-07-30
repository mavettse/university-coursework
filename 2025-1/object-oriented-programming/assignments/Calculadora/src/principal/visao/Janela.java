package principal.visao;

import principal.modelo.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame{
    private JPanel janela;
    private JButton porcentagemButton;
    private JButton pontoButton;
    private JButton a0Button;
    private JButton igualButton;
    private JButton somarButton;
    private JTextField visor;
    private JButton x2Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton subtrairButton;
    private JButton ceButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton multiplicarButton;
    private JButton cButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton dividirButton;

    public Janela(){
        Calculadora calculadora = new Calculadora();

        setContentPane(janela);
        setTitle("Calculadora");
        setSize(360,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        visor.setText("");

        ActionListener numeroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botao = (JButton) e.getSource();
                calculadora.concatenar(botao.getText());
                visor.setText(calculadora.getVisor());
            }
        };

        ActionListener operacaoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botao = (JButton) e.getSource();
                calculadora.setOperacao(botao.getText());
                visor.setText(calculadora.getVisor());
            }
        };

        pontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadora.ponto();
                visor.setText(calculadora.getVisor());
            }
        });

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadora.excluirC();
                visor.setText(calculadora.getVisor());
            }
        });

        ceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadora.excluirCE();
                visor.setText(calculadora.getVisor());
            }
        });

        igualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadora.igual();
                visor.setText(calculadora.getVisor());
            }
        });

        a0Button.addActionListener(numeroListener);
        a1Button.addActionListener(numeroListener);
        a2Button.addActionListener(numeroListener);
        a3Button.addActionListener(numeroListener);
        a4Button.addActionListener(numeroListener);
        a5Button.addActionListener(numeroListener);
        a6Button.addActionListener(numeroListener);
        a7Button.addActionListener(numeroListener);
        a8Button.addActionListener(numeroListener);
        a9Button.addActionListener(numeroListener);

        somarButton.addActionListener(operacaoListener);
        subtrairButton.addActionListener(operacaoListener);
        multiplicarButton.addActionListener(operacaoListener);
        dividirButton.addActionListener(operacaoListener);
        porcentagemButton.addActionListener(operacaoListener);
        x2Button.addActionListener(operacaoListener);

    }

    public static void main(String[] args) {
        Janela calculadora = new Janela();

    }
}
