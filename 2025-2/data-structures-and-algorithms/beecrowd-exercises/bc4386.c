#include <stdio.h>

int mdc(int a, int b){
    if(a%b == 0){
        return b;
    }
    
    mdc(b, a%b);
}
 
int main() {

    int a, b;
 
    printf("Digite dois numeros inteiros: ");
    scanf("%d%d", &a, &b);
    
    int resposta = (a > b) ? mdc(a,b) : mdc(b,a);
    
    printf("Resultado: %d\n", resposta);
 
    return 0;
}