#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 3

int main(){
    srand(time(NULL));
    int matriz[MAX][MAX], i, j, soma = 0, cont = 0;

    for(i = 0; i < MAX; ++i)
        for(j = 0; j < MAX; ++j)
            matriz[i][j] = rand()%100;

    for(i = 0; i < MAX; ++i)
        for(j = 0; j < MAX; ++j){
            soma+= matriz[i][j];
            if(matriz[i][j] > 50)
                cont++;
        }

    printf("Soma de todos os valores: %d\nQuantidade de números maiores que 50: %d\n", soma, cont);

    return 0;
}