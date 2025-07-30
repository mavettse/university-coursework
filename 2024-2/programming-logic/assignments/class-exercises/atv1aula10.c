#include <stdio.h>

int checa(int vet[], int tam, int C){

    for(int i = 0; i < tam; ++i){
        for(int j = 1; i < tam; ++i)
            if(vet[i] * vet[j] == C)
            return 1;
    }
    
    return -1;
}