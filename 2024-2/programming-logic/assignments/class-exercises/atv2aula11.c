#include <stdio.h>
#define MAX 10

int main () {
    int m[MAX][MAX], posicao = 0;
    for(int i = 0; i < MAX; ++i)
        for(int j = 0; j < MAX; ++j)
            scanf("%d", &m[i][j]);
            
    for(int i = 0; i < MAX; ++i)
        for(int j = 0; j < MAX; ++j)
            if(m[i][j] != 0)
                posicao++;     
                
    printf ("%d\n", posicao);          
    
    return 0;
}