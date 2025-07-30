#include <stdio.h>

#define MAX 4

int main(){
    int m[MAX][MAX],mt[MAX][MAX];
    
    for(int i = 0; i < MAX; ++i)
        for(int j = 0; j < MAX; ++j)
            scanf("%d", &m[i][j]);
            
    for(int i = 0; i < MAX; ++i)
        for(int j = 0; j < MAX; ++j)
            mt[i][j] = m[j][i];
            
    printf("Matriz: \n");       
    for(int i = 0; i < MAX; ++i){
        for(int j = 0; j < MAX; ++j)
            printf("%d ", m[i][j]);               
        printf("\n");
    }
    
    printf("Transposta: \n");       
    for(int i = 0; i < MAX; ++i){
        for(int j = 0; j < MAX; ++j)
            printf("%d ", mt[i][j]);               
        printf("\n");
    }
    
    
    return 0;
    }