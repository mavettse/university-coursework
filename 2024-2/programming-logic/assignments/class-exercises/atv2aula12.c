#include <stdio.h>

int main(){
    int m, n;
    printf("Digite o tamanho da matriz (m x n):\n");
    scanf("%d %d", &m, &n);

    int a[m][n], transposta[n][m];
    printf("Digite os valores da matriz (linha a linha):\n");
    for(int i=0; i<m; ++i)
        for(int j=0; j<n; ++j)
            scanf("%d", &a[i][j]);

    for(int i=0; i<m; ++i)
        for(int j=0; j<n; ++j)
            transposta[j][i] = a[i][j];

    printf("Matriz Transposta:\n");
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j)
            printf("%d ", transposta[i][j]);
        printf("\n");
    }

    
    return 0;
}