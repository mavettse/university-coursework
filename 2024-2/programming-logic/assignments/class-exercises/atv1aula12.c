#include <stdio.h>

#define MAX 100

void leMatriz(double mat[][MAX], int n){
    int i, j;
    printf("Lendo dados da matriz (linha por linha)\n");

    for(i=0; i<n; ++i)
        for(j=0; j<n; ++j)
            scanf("%lf", &mat[i][j]);
}

void imprimeMatriz(double mat[][MAX], int n){
    int i, j;
    printf("Dados da matriz (linha por linha)\n");

    for(i=0; i<n; ++i){
        for(j=0; j<n; ++j)
            printf("%g ", mat[i][j]);
        printf("\n");
    }
}

void multiplica(double mat1[][MAX], double mat2[][MAX], int n){
    int i, j, k;
    double resp[MAX][MAX];

    for(i=0; i<n; ++i)
        for(j=0; j<n; ++j){
            resp[i][j] = 0;
            for(k=0; k<n; ++k)
                resp[i][j] = resp[i][j] + (mat1[i][k]*mat2[k][j]);
        }

    imprimeMatriz(resp, n);
}

void soma(double mat1[][MAX], double mat2[][MAX], int n){
    int i, j;
    double resp[MAX][MAX];

    for(i=0; i<n; ++i)
        for(j=0; j<n; ++j)
            resp[i][j] = mat1[i][j] + mat2[i][j];

    imprimeMatriz(resp, n);
}

void subtracao(double mat1[][MAX], double mat2[][MAX], int n){
    int i, j;
    double resp[MAX][MAX];

    for(i=0; i<n; ++i)
        for(j=0; j<n; ++j)
            resp[i][j] = mat1[i][j] - mat2[i][j];

    imprimeMatriz(resp, n);
}

void multiplicaEscalar(double mat[][MAX], int escalar, int n){
    int i, j;
    double resp[MAX][MAX];

    for(i=0; i<n; ++i)
        for(j=0; j<n; ++j)
            resp[i][j] = mat[i][j] * escalar;

    imprimeMatriz(resp, n);
}

void transposta(double mat[][MAX], int n){
    int i, j;
    double resp[MAX][MAX];
    
    for(i=0; i<n; ++i)
        for(j=0; j<n; ++j) 
            resp[i][j] = mat[j][i];

    imprimeMatriz(resp, n);
}

int main() {
    double mat1[MAX][MAX], mat2[MAX][MAX];
    int n, operacao;

    printf("Qual dimensão das matrizes: ");
    scanf("%d", &n);

    leMatriz(mat1, n);
    leMatriz(mat2, n);

    while(1){
        printf("Digite o número correspondente à operação que você deseja realizar entre as matrizes:\n1. Somar\n2. Subtrair\n3. Multiplicar\n4. Multiplicar por um escalar\n5. Transposta\n6. Sair\n");
        
        scanf("%d", &operacao);

        switch(operacao){
            case 1:
                soma(mat1, mat2, n);
                break;
            case 2:
                subtracao(mat1, mat2, n);
                break;
            case 3:
                multiplica(mat1, mat2, n);
                break;
            case 4:
                printf("Digite o escalar: ");
                int op;
                scanf("%d", &op);
                printf("A matriz 1 multiplicada pelo escalar %d é:\n", op);
                multiplicaEscalar(mat1, op, n);
                printf("A matriz 2 multiplicada pelo escalar %d é:\n", op);
                multiplicaEscalar(mat2, op, n);
                break;
            case 5:
                printf("A matriz 1 transposta é:\n");
                transposta(mat1, n);
                printf("A matriz 2 transposta é:\n");
                transposta(mat2, n);
                break;
            default: 
                return 0;
        }
    }

    return 0;
}
