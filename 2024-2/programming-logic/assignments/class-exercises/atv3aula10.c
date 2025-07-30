#include <stdio.h>

double media(int vet[], int tam){
    double m = 0;
    for(int i = 0; i < tam; ++i){
        m += vet[i];
    }
    m = m/tam;
    return m;
}