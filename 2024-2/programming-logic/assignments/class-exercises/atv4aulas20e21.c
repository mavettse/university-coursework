#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Produto {
    char nome[30];
    int codigo;
    float preco;
} produto;

int main(){
    produto *ptr = malloc(10*sizeof(produto));

    strcpy(ptr[0].nome, "Pe de Moleque"); //alterando posicao 0
    ptr[0].codigo = 13205;
    ptr[0].preco = 0.20;

    strcpy(ptr[1].nome, "Cocada Baiana"); //alterando posicao 1
    ptr[1].codigo = 15202;
    ptr[1].preco = 0.50;

    for(int i = 0; i < 2; ++i)
        printf("Produto: %s\nCódigo: %d\nValor: R$ %.2f\n\n", ptr[i].nome, ptr[i].codigo, ptr[i].preco);

    free(ptr);

    return 0;
}