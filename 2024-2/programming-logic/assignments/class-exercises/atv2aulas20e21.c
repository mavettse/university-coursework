#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char *seq, c;
    int tam = 0, cap = 1;
    seq = malloc(cap*sizeof(char));

    printf("Digite algo:\n");

    while((c = getchar()) != '\n'){
        if(tam + 1 >= cap){
            cap*=2;
            seq = realloc(seq,cap*sizeof(char));
        }
        seq[tam++] = c;
    }
    seq[tam] = '\0';

    char *alt = malloc(strlen(seq)*sizeof(char));
    strcpy(alt, seq);

    for(int i = 0; i < strlen(alt); ++i)
        if(alt[i] == ' '){
            for(int j = i; j < strlen(alt); ++j)
                alt[j] = alt[j+1];
            i--;
        }

    puts(alt);
    
    return 0;
}