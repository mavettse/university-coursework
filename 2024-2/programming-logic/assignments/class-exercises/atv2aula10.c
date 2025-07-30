#include <stdio.h>

int maiorValor(int vet[], int tam){
    int maior = vet[0];
    for(int i = 0; i < tam; ++i){
        if(vet[i] > maior)
            maior = vet[i];
    }
    return maior;
}