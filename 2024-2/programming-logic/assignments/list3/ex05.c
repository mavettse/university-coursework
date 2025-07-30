#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    char nome[100];
    char cpf[13];
    char curso[50];
} USUARIO;

typedef struct{
    USUARIO *usuario;
    int capacidade;
    int atual;
} VetorDinamico;

void INICIALIZAR(VetorDinamico *vetor){
    vetor->capacidade = 5;
    vetor->atual = 0;
    
    if( (vetor->usuario = malloc(vetor->capacidade*sizeof(USUARIO))) == NULL){
        printf("Falha ao alocar memoria\n");
        exit(1);
    }
}

void GRAVA(FILE *arq, VetorDinamico *vetor){
    rewind(arq);
    fwrite(vetor->usuario, sizeof(USUARIO), vetor->atual, arq);
    fflush(arq);
}

void INCLUIR(FILE *arq, VetorDinamico *vetor){
    if(vetor->atual+1 >= vetor->capacidade){
        vetor->capacidade += 5;
        if( (vetor->usuario = realloc(vetor->usuario, vetor->capacidade*sizeof(USUARIO))) == NULL){
            printf("Falha ao realocar memoria\n");
            free(vetor->usuario);
            fclose(arq);
            exit(1);
        }
    }

    char temp[100];

    printf("\nDigite o nome do usuario: ");
    fgets(temp, 100, stdin);
    temp[strcspn(temp, "\n")] = '\0';
    strcpy(vetor->usuario[vetor->atual].nome, temp);
    fflush(stdin);

    printf("Digite o CPF do usuario (somente numeros): ");
    fgets(temp, 13, stdin);
    temp[strcspn(temp, "\n")] = '\0';
    strcpy(vetor->usuario[vetor->atual].cpf, temp);
    fflush(stdin);

    printf("Digite o curso do usuario: ");
    fgets(temp, 50, stdin);
    temp[strcspn(temp, "\n")] = '\0';
    strcpy(vetor->usuario[vetor->atual].curso, temp);
    fflush(stdin);

    vetor->atual++;
    GRAVA(arq, vetor);
}

void EXCLUIR(FILE *arq, VetorDinamico *vetor){
    if(vetor->atual == 0){
        printf("Nao ha usuarios cadastrados\n");
        return;
    }

    char temp[13];

    printf("\nDigite o CPF do usuario que deseja excluir (somente numeros): ");
    fgets(temp, 13, stdin);
    temp[strcspn(temp, "\n")] = '\0';
    fflush(stdin);

    for(int i = 0; i < vetor->atual; ++i)
        if( (strcmp(temp, vetor->usuario[i].cpf)) == 0){
            for(int j = i; j < vetor->atual - 1; ++j)
                vetor->usuario[j] = vetor->usuario[j+1];
            vetor->atual--;
            printf("Usuario excluido com sucesso\n");
            GRAVA(arq, vetor);
            return;
        } 
    printf("Usuario nao encontrado\n");
}

void BUSCAR(VetorDinamico *vetor){
    if(vetor->atual == 0){
        printf("Nao ha usuarios cadastrados\n");
        return;
    }

    char temp[13];

    printf("\nDigite o CPF do usuario que deseja buscar (somente numeros): ");
    fgets(temp, 13, stdin);
    temp[strcspn(temp, "\n")] = '\0';
    fflush(stdin);

    for(int i = 0; i < vetor->atual; ++i)
        if( (strcmp(temp, vetor->usuario[i].cpf)) == 0){
            printf("Nome: %s\nCPF: %s\nCurso: %s\n", vetor->usuario[i].nome, vetor->usuario[i].cpf, vetor->usuario[i].curso);
            return;
        } 
    printf("Usuario nao encontrado\n");
}

void LISTAR(FILE *arq, VetorDinamico *vetor){
    fseek(arq, 0, SEEK_END);
    int tamanho = ftell(arq);
    rewind(arq);
    if(tamanho == 0){
        printf("O arquivo está vazio\n");
        return;
    }

    printf("\nUsuarios cadastrados:\n");
    for (int i = 0; i < vetor->atual; i++) 
        printf("Nome: %s\n", vetor->usuario[i].nome);
}

void CONTAR(FILE *arq, VetorDinamico *vetor){
    fseek(arq, 0, SEEK_END);
    int tamanho = ftell(arq);
    rewind(arq);
    if(tamanho == 0){
        printf("O arquivo está vazio\n");
        return;
    }

    int cont = 0;
    USUARIO temp;
    while((fread(&temp, sizeof(USUARIO), 1, arq)) == 1)
        if( (strcmp(temp.curso, "Engenharia de Computacao")) == 0)
            cont++;
    if(cont > 0)
        printf("%d aluno(s) cursam Engenharia de Computação\n", cont);
    else printf("Nenhum aluno cursa Engenharia de Computação\n");
}

int main(){
    VetorDinamico vetor;
    int n;
    FILE *arq;

    INICIALIZAR(&vetor);
    if( (arq = fopen("biblioteca.bin", "w+b")) == NULL){
        printf("Falha ao criar arquivo\n");
        return 1;
    }
    
    while(1){
        printf("\nDigite a opcao desejada:\n1. Incluir usuario\n2. Excluir usuario\n3. Buscar usuario\n4. Listar todos os usuarios\n5. Contar quantos alunos cursam Engenharia de Computacao\n6. Sair\n");
        scanf("%d", &n);
        fflush(stdin);

        switch(n){
            case 1:
                INCLUIR(arq, &vetor);
                break;
            case 2:
                EXCLUIR(arq, &vetor);
                break;
            case 3:
                BUSCAR(&vetor);
                break;
            case 4:
                LISTAR(arq, &vetor);
                break;
            case 5:
                CONTAR(arq, &vetor);
                break;
            case 6:
                free(vetor.usuario);
                fclose(arq);
                return 0;
            default:
                printf("Opcao invalida\n");
        }
    }
    return 0;
}