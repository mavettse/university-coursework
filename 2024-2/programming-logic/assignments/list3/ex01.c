#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    int capacidade = 1, atual = 0, posicao = 0;
    char c, *string, *copia;

    if( (string = malloc(capacidade*sizeof(char))) == NULL){
        printf("Erro ao alocar memória\n");
        return 1;
    }

    printf("Digite algo: ");
    while( (scanf("%c",&c)) != EOF && c != '\n'){
        if(capacidade + 1 >= atual){ 
            capacidade += 10;
            if( (string = realloc(string, capacidade*sizeof(char))) == NULL){
                printf("Erro ao realocar memória\n");
                return 1;
            }
        }
        string[posicao++] = c;
    }
    string[posicao] = '\0';

    if( (copia = malloc(posicao*sizeof(char))) == NULL){
        printf("Erro ao alocar memória\n");
        return 1;
    }

    for(int i = 0; i < posicao; ++i)
        copia[i] = string[i];
    copia[posicao] = '\0';
    
    for(int i = 0; copia[i] != '\0'; ++i)
        if(copia[i] == ' '){
            for(int j = i; copia[j] != '\0'; ++j)
                copia[j] = copia [j+1];
            i--;
        }

    puts(copia);

    free(string);
    free(copia);

    return 0;
}