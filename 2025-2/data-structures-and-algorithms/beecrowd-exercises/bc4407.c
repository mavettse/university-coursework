#include <stdio.h>
#include <stdlib.h>
 
int main() {
    int n;
    scanf("%d",&n);

    int ptrSize = 375000;
    int *numero = (int*)calloc(ptrSize, sizeof(int));

    numero[0] = 1;
    int endPtr = 1;

    for(int fat = n; fat > 1; --fat){ // loop para iterar todos os numeros de n a 2

        for(int i = 0; i < endPtr; ++i){ // faz a multiplicacao dentro do vetor
            numero[i] *= fat;
        }

        int ptr = 0;
        int carry = 0;

        while(ptr < endPtr || carry != 0){ // loop para deixar 4 algarismos por posicao no vetor
            int temp = numero[ptr] + carry;
            carry = temp/10000;
            numero[ptr] = temp%10000;

            ptr++;

            if(ptr >= ptrSize){ 
                ptrSize += 375000;
                numero = (int *)realloc(numero, ptrSize * sizeof(int));
                
                if(numero == NULL){
                    free(numero);
                    return 1;
                }                                
            }
        }

        if(ptr>endPtr){
            endPtr = ptr;
        }
    }

    printf("Resultado: %d", numero[endPtr-1]);

    for(int i = endPtr-2; i >= 0; --i){
        printf("%04d",numero[i]);
    }    

    printf("\n");
    free(numero);
    
    return 0;
}