#include <stdio.h>
#include <stdlib.h>

void lerMatriz(double **m, int n){
    for(int i = 0; i < n; ++i)
        for(int j = 0; j < n; ++j){
            printf("Digite o %dº elemento da %dª linha\n", j+1, i+1);
            scanf("%lf", &m[i][j]);
    }
}
void imprimeMatriz(double **m, int n){
    printf("A soma das duas matrizes é:\n");
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j)
            printf("%g ", m[i][j]);
        printf("\n");
    }
}
void somaMatriz(double **ma, double **mb, int n){
    for(int i = 0; i < n; ++i)
        for(int j = 0; j < n; ++j)
            ma[i][j] += mb[i][j];
    imprimeMatriz(ma,n);
}

int main(){
    double **ma, **mb;
    int n;

    printf("Digite a dimensão das matrizes: ");
    scanf("%d", &n);

    ma = malloc(n*sizeof(double*));
    mb = malloc(n*sizeof(double*));
    
    if (ma == NULL || mb == NULL) {
        printf("Erro na alocação de memória!\n");
        return 1;
    }


    for(int i = 0; i < n; ++i){
        ma[i] = malloc(n*sizeof(double));
        mb[i] = malloc(n*sizeof(double));

        if (ma[i] == NULL || mb[i] == NULL) {
            printf("Erro na alocação de memória!\n");
            return 1;
        }
}

    lerMatriz(ma, n); lerMatriz(mb, n); somaMatriz(ma, mb, n);

    for(int i = 0; i < n; ++i){
        free(ma[i]); free(mb[i]);
    } free(ma); free(mb);

    return 0;
}