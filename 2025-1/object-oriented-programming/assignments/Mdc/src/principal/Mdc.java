package principal;

import java.util.Arrays;
        
public class Mdc {
    private final int[] num;
    private int resto;
    
    public Mdc(int[] num){
        this.num = num;
    }
    
    public int calcularMDC(){
        Arrays.sort(num);
        if(num[1] == 0)
            return num[0];
        else
            while(num[0] != 0){
                resto = num[1] % num[0];
                num[1] = num[0];
                num[0] = resto;
            }        
        return num[1];
    }
}
