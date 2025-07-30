package principal.modelo;

public class Calculadora {
    private double fator1;
    private double fator2;
    private double resultado;

    private String sfator1;
    private String sfator2;
    private String operacao;

    private String visor;

    public Calculadora(){
        sfator1 = "";
        sfator2 = "";
        operacao = "";
        fator1 = 0;
        fator2 = 0;
        resultado = 0;
        visor = "";
    }

    public void concatenar(String num){
        if(operacao.isEmpty()) {
            sfator1 += num;
            visor = sfator1;
        } else {
            if(operacao.equals("^2"))
                return;

            sfator2 += num;
            visor = sfator1 + operacao + sfator2;
        }
    }

    public void ponto(){
        if(operacao.isEmpty()) {
            if(sfator1.contains("."))
                return;

            sfator1 += ".";
            visor = sfator1;
        } else {
            if(operacao.equals("^2") || sfator2.contains("."))
                return;

            sfator2 += ".";
            visor = sfator1 + operacao + sfator2;
        }
    }

    public void excluirC(){
        sfator1 = "";
        sfator2 = "";
        operacao = "";

        visor = sfator1 + operacao + sfator2;
    }


    public void excluirCE(){
        if(operacao.isEmpty()) {
            if (!sfator1.isEmpty())
                sfator1 = sfator1.substring(0, sfator1.length() - 1);
        } else {
            if (sfator2.isEmpty())
                operacao = "";
            else
                sfator2 = sfator2.substring(0, sfator2.length() - 1);
        }
        visor = sfator1 + operacao + sfator2;
    }

    private double soma(double num1, double num2){
        return num1 + num2;
    }

    private double subtracao(double num1, double num2){
        return num1 - num2;
    }

    private double multiplicacao(double num1, double num2){
        return num1 * num2;
    }

    private double divisao(double num1, double num2){
        return num1 / num2;
    }

    private double porcentagem(double num1, double num2){
        return (num1*num2)/100;
    }

    private double potencia(double num1){
        return Math.pow(num1, 2);
    }

    public void igual(){
        fator1 = sfator1.isEmpty() ? 0 : Double.parseDouble(sfator1);
        fator2 = sfator2.isEmpty() ? 0 : Double.parseDouble(sfator2);

        boolean erro = false;

        switch(operacao){
            case "+":
                resultado = soma(fator1, fator2);
                break;
            case "-":
                resultado = subtracao(fator1, fator2);
                break;
            case "*":
                resultado = multiplicacao(fator1, fator2);
                break;
            case "/":
                if(fator2 == 0){
                    visor = "ERRO! Divisão por zero.";
                    erro = true;
                } else
                    resultado = divisao(fator1, fator2);
                break;
            case "%":
                resultado = porcentagem(fator1, fator2);
                break;
            case "^2":
                resultado = potencia(fator1);
                break;
            default:
                resultado = fator1;
                break;
        }

        if(!erro)
            visor = String.valueOf(resultado);

        sfator1 = "";
        sfator2 = "";
        operacao = "";
    }

    public double getFator1() {
        return fator1;
    }

    public void setFator1(double fator1) {
        this.fator1 = fator1;
    }

    public double getFator2() {
        return fator2;
    }

    public void setFator2(double fator2) {
        this.fator2 = fator2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getSfator1() {
        return sfator1;
    }

    public void setSfator1(String sfator1) {
        this.sfator1 = sfator1;
    }

    public String getSfator2() {
        return sfator2;
    }

    public void setSfator2(String sfator2) {
        this.sfator2 = sfator2;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
        sfator2 = "";
        visor = sfator1 + operacao;
    }

    public String getVisor() {
        return visor;
    }

    public void setVisor(String visor) {
        this.visor = visor;
    }
}
