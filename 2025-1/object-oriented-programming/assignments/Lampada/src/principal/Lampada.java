package principal;

public class Lampada {
    private EstadoLampada estado;
    private int luminosidade;
    private TipoLampada tipo;
    
    public Lampada(EstadoLampada estado, int luminosidade, TipoLampada tipo){
        this.estado = estado;
        this.luminosidade = luminosidade;
        this.tipo = tipo;
    }
    
    public enum EstadoLampada{
        APAGADA, ACESA, MEIA_LUZ, QUEIMADA;
    }
    
    public enum TipoLampada{
        COMUM, AJUSTAVEL;
    }
    
    public void ajustarLuminosidade(int valor){
        if(valor < 0 || valor > 100)
            throw new IllegalArgumentException("O valor deve estar entre 0 e 100\n");
        
        if(estado == EstadoLampada.QUEIMADA) // se a lâmpada estiver queimada
            return;
        
        if(valor == 100) // definir o estado de todas
            estado = EstadoLampada.ACESA;
        else if(valor > 0 && valor < 100)
            estado = EstadoLampada.MEIA_LUZ;
        else
            estado = EstadoLampada.APAGADA;

        if(tipo == TipoLampada.COMUM) // definir a luminosidade se a lampada for comum
            if(valor == 100)
                luminosidade = 100;
            else if(valor > 0 && valor < 100)
                luminosidade = 50;
            else
                luminosidade = 0;
        else // definir a luminosidade se a lampada for ajustavel
            luminosidade = valor;
        
    }
    
    public void queimar(){
        estado = EstadoLampada.QUEIMADA;
        luminosidade = 0;
    }
    
    public EstadoLampada getEstado(){
        return estado;
    }
    
    public int getLuminosidade(){
        return luminosidade;
    }
    
    public TipoLampada getTipo(){
        return tipo;
    }
    
    public void setTipo(TipoLampada tipo){
        this.tipo = tipo;
    }
}