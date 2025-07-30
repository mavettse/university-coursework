package modelo;

import java.util.Random;

public class Jogo{
    private int respostaCorreta;
    private int acertos;
    private int num1;
    private int num2;
    private String operacao;
    private String operacoes;
    private String visor;
    Random gerador;

    public Jogo(){
        respostaCorreta = 0;
        acertos = 0;
        num1 = 0;
        num2 = 0;
        operacao = "";
        operacoes = "+-*/";
        visor = "";
        gerador = new Random();
    }

    public void excluirC(){
        visor = "";
    }

    public void iniciarRodada(){
        num1 = gerador.nextInt(100) + 1;
        num2 = gerador.nextInt(100) + 1;
        operacao = String.valueOf(operacoes.charAt(gerador.nextInt(4)));
        calcularResposta();
        visor = "";
    }

    public boolean conferirResposta(String tentativa){
        int aux = Integer.parseInt(tentativa);
        boolean acertou = (aux == respostaCorreta);

        if(acertou)
            acertos++;

        return acertou;
    }

    public void reiniciarJogo(){
        acertos = 0;
    }

    private void calcularResposta(){
        switch(operacao){
            case "+":
                respostaCorreta = num1 + num2;
                break;
            case "-":
                respostaCorreta = num1 - num2;
                break;
            case "*":
                respostaCorreta = num1 * num2;
                break;
            case "/":
                respostaCorreta = num1 / num2;
                break;
            default:
                break;
        }
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getVisor() {
        return visor;
    }

    public void setVisor(String num) {
        visor += num;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
