#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int numero;
} NUMERO;

typedef struct{
    NUMERO *num;
    int capacidade;
    int atual;
} VetorDinamico;

void INIC(VetorDinamico *vetor){
    vetor->capacidade = 2;
    vetor->atual = 0;

    if( (vetor->num = malloc(vetor->capacidade*sizeof(NUMERO))) == NULL){
        printf("Falha ao alocar memoria\n");
        exit(1);
    }
}

void INSERIR(VetorDinamico *vetor, int valor){
    if(vetor->atual + 1 >= vetor->capacidade){ //se o vetor estiver cheio, aumenta sua capacidade
            vetor->capacidade+=5;
            if( (vetor->num = realloc(vetor->num, vetor->capacidade*sizeof(NUMERO))) == NULL){
                printf("Falha ao realocar memoria\n");
                free(vetor->num);
                exit(1);
            }
        }

    if(valor%2 != 0){// se o valor a ser inserido for impar
        for(int i = vetor->atual; i > 0; --i)
            vetor->num[i] = vetor->num[i-1];
        vetor->num[0].numero = valor;
    } else  //se o valor a ser inserido for par
        vetor->num[vetor->atual].numero = valor;

    vetor->atual++;
}   

void RETIRAR(VetorDinamico *vetor, int valor){
    for(int i = 0; i <= vetor->atual; ++i)
        if(vetor->num[i].numero == valor){
            for(int j = i; j < vetor->atual; ++j)
                vetor->num[j] = vetor->num[j+1];
            printf("\n%d foi retirado com sucesso\n\n", valor);
            vetor->atual--;
            return;
        }
    printf("\n%d nao foi encontrado\n\n", valor);
}

void LISTAR(VetorDinamico *vetor){
    printf("\nOs elementos existentes sao:\n");
    for(int i = 0; i < vetor->atual; ++i)
        printf("%d ", vetor->num[i].numero);
    printf("\n\n");
}

int main(){
    VetorDinamico vetor;
    INIC(&vetor);
    int n, valor;

    while(1){
        printf("\nSelecione uma opcao:\n1. Insere um numero\n2. Retira um numero\n3. Lista todos os numeros\n4. Finaliza o programa\n");
        scanf("%d", &n);

        switch(n){
            case 1:
                printf("\nDigite o numero que deseja inserir (somente inteiros positivos): ");
                scanf("%d",&valor);
                INSERIR(&vetor, valor);
                break;
            case 2:
                printf("\nDigite o numero que deseja retirar (somente inteiros positivos): ");
                scanf("%d",&valor);
                RETIRAR(&vetor, valor);
                break;
            case 3:
                LISTAR(&vetor);
                break;
            case 4:
                free(vetor.num);
                return 0;
        }
    }
}