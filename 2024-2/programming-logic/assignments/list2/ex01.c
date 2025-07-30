#include <stdio.h>
#include <string.h>

int main(){
    char s[40];
    fgets(s, 40, stdin);
    s[strcspn(s, "\n")] = '\0';

    int tamanho = strlen(s);
    char *ptr = &s[tamanho - 1], inversa[tamanho];

    for(int i = 0; i < tamanho; ++i, --ptr){
        inversa[i] = *ptr;
    }

    inversa[tamanho] = '\0';
    printf("%s\n%s\n", s, inversa);

    return 0;
}