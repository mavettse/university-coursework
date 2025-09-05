#include <stdio.h>

void dec2bin(int dec){
    if(dec > 0){
        dec2bin(dec/2);
        printf("%d", dec%2);
    }
}
 
int main() {
    
    int numDigitado;
 
    printf("Digite um numero inteiro: ");
    scanf("%d", &numDigitado);
    
    printf("Resultado: ");
    
    if(numDigitado == 0){
        printf("0");
    } else {
        dec2bin(numDigitado);
    }
    
    printf("\n");
    
    return 0;
}