#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <limits.h>

// declaração das structs
typedef int TipoChave;

typedef struct {
    TipoChave Chave;
} TipoItem;

typedef struct TipoCelula *TipoApontador;

typedef struct TipoCelula {
    TipoItem Item;
    TipoApontador Prox;
} TipoCelula;

typedef struct {
    TipoApontador Primeiro, Ultimo;
} TipoLista;

// inserção das funções do ziviani
void FLVazia(TipoLista *Lista) {
    Lista -> Primeiro = (TipoApontador) malloc(sizeof(TipoCelula));
    Lista -> Ultimo = Lista -> Primeiro;
    Lista -> Primeiro -> Prox = NULL;
}

int Vazia(TipoLista Lista) {
    return (Lista.Primeiro == Lista.Ultimo); 
}

void Insere(TipoItem x, TipoLista *Lista) {
    Lista -> Ultimo -> Prox = (TipoApontador) malloc(sizeof(TipoCelula));
    Lista -> Ultimo = Lista -> Ultimo -> Prox;
    Lista -> Ultimo -> Item = x;
    Lista -> Ultimo -> Prox = NULL;
}

void Retira(TipoApontador p, TipoLista *Lista, TipoItem *Item) {
    // O item a ser retirado e o seguinte ao apontado por p
    TipoApontador q;
    
    if (Vazia(*Lista ) || p == NULL || p->Prox == NULL) { 
        printf ("Erro: Lista vazia ou posicao nao existe\n");
        return;
    }
    
    q = p->Prox;
    *Item = q -> Item;
    p -> Prox = q -> Prox;

    if (p -> Prox == NULL){
        Lista -> Ultimo = p;
    }

    free(q);
}

void Imprime(TipoLista Lista) {

    TipoApontador Aux;
    Aux = Lista.Primeiro -> Prox;

    while (Aux != NULL) {
        printf ("%d\n" , Aux->Item.Chave);
        Aux = Aux->Prox;
    }
}

void ImprimeFinal(TipoLista Lista) {

    printf("Lista final: ");
    TipoApontador Aux;
    Aux = Lista.Primeiro -> Prox;

    while (Aux != NULL) {
        printf ("%d" , Aux->Item.Chave);
        Aux = Aux->Prox;

        if(Aux != NULL){
            printf(",");
        } else {
            printf("\n");
        }
    }  
}

int main(){

    // armazena o nome do arquivo de entrada
    char arquivo[50];
    printf("Digite o nome do arquivo de entrada: ");
    getchar();
    scanf("%s", arquivo);

    // abre o arquivo
    FILE *ptr_arquivo;
    ptr_arquivo = fopen(arquivo, "r");
    if (ptr_arquivo == NULL){
        printf("Nao foi possivel abrir o arquivo\n");
        return 1;
    }

    // fazendo a leitura de dentro do arquivo
    int K;
    fscanf(ptr_arquivo, "%d", &K);

    // cria um vetor de K listas alocado dinamicamente
    TipoLista *listas;
    listas = (TipoLista*) malloc (K * sizeof(TipoLista));
    
    // limpa as listas
    for(int i = 0; i < K; ++i){
        FLVazia(&listas[i]);
    }

    // insere os valores nas respectivas listas
    char linha[200];
    char *fragmento;

    for(int i = 0; i < K; ++i){
    
        if (fgets(linha, sizeof(linha), ptr_arquivo) == NULL) {
            break;
        }

        // separa a string linha em partes toda vez que ve um espaco ou nova linha
        fragmento = strtok(linha, " \n");
     
        // para quando não existir mair fragmentos da mesma linha
        while (fragmento != NULL){
            // transforma o fragmento em um inteiro
            int elemento = atoi(fragmento);

            TipoItem item;
            item.Chave = elemento;
            Insere(item, &listas[i]);

            // pega o proximo fragmento da mesma string
            fragmento = strtok(NULL, " \n");
        }
    }

    // fecha o arquivo
    fclose(ptr_arquivo);

    // cria a lista final 
    TipoLista lista_final;
    FLVazia(&lista_final);

    // faz a intercalação
    while(1){
        int menor_indice = -1;
        TipoItem menor_item;
        menor_item.Chave = INT_MAX;

        for(int i = 0; i < K; ++i){

            if(Vazia(listas[i])){
                continue;
            }

            int item_atual = listas[i].Primeiro->Prox->Item.Chave;

            if(item_atual < menor_item.Chave){
                menor_item.Chave = item_atual;
                menor_indice = i;
            }
        }

        // se menor_indice = -1, todas as listas estão vazias
        if(menor_indice == -1){
            break;
        } 

        // se menor_indice != -1, retira da lista do incide e insere na lista final
        Retira(listas[menor_indice].Primeiro, &listas[menor_indice], &menor_item);
        Insere(menor_item, &lista_final);
    }

    // faz aimpressao final
    ImprimeFinal(lista_final);

    return 0;
}