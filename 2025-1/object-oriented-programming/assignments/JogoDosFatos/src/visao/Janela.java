package visao;

import modelo.Jogo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame{
    private JPanel janela;
    private JPanel superior;
    private JPanel inferior;
    private JPanel centro;
    private JButton a7Button;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton cButton;
    private JButton a0Button;
    private JButton OKButton;
    private JLabel num1;
    private JLabel operador;
    private JLabel num2;
    private JLabel igual;
    private JLabel sep1;
    private JTextField tela;
    private JLabel sep2;
    private JLabel qtdPontos;
    private JLabel info2;
    private JLabel info1;
    private JButton passarButton;
    private JButton reiniciarButton;
    private JButton sairButton;

    private Jogo jogoDosFatos;

    public Janela() {
        jogoDosFatos = new Jogo();
        alterarDisplay();

        setContentPane(janela);
        setTitle("Jogo Dos Fatos");
        setSize(585, 310);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        ActionListener numeroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botao = (JButton) e.getSource();
                jogoDosFatos.setVisor(botao.getText());
                tela.setText(jogoDosFatos.getVisor());
            }
        };

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

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogoDosFatos.excluirC();
                tela.setText(jogoDosFatos.getVisor());
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        passarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarDisplay();
            }
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!jogoDosFatos.conferirResposta(tela.getText()))
                    JOptionPane.showMessageDialog(Janela.this, "Resposta incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
                alterarDisplay();
            }
        });

        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogoDosFatos.reiniciarJogo();
                alterarDisplay();
                JOptionPane.showMessageDialog(Janela.this, "Jogo reiniciado com sucesso!\nSeus pontos foram zerados.",
                        "Reiniciar Jogo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void alterarDisplay(){
        jogoDosFatos.iniciarRodada();

        num1.setText(String.valueOf(jogoDosFatos.getNum1()));
        num2.setText(String.valueOf(jogoDosFatos.getNum2()));
        operador.setText(jogoDosFatos.getOperacao());

        tela.setText(jogoDosFatos.getVisor());
        qtdPontos.setText(String.valueOf(jogoDosFatos.getAcertos()));
    }

    public static void main(String[] args) {
        Janela joguinho = new Janela();
    }
}
