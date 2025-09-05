#include <stdio.h>

int Digitos(int N){
    
    if(N >= 10){
        return Digitos(N/10) + 1;
    }
    
    return 1;
}
 
int main() {
    int numDigitado;
    
    printf("Digite um numero inteiro: ");
    scanf("%d", &numDigitado);
    
    printf("Resultado: %d\n", Digitos(numDigitado));
    
    return 0;
}