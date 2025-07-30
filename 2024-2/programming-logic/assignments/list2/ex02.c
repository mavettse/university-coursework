#include <stdio.h>
#include <string.h>

#define MAX 80

void trocaPalavra(char *string, int n){
    char palavraInicial[MAX], palavraFinal[MAX], frase[MAX];
    char *ptrInicio = string, *ptrFim = &string[n-1];
    
    int cont = 0;
    while(*ptrInicio != ' ' && *ptrInicio != '\0')
        palavraFinal[cont++] = *ptrInicio++;
    palavraFinal[cont] = '\0';

    while(*ptrFim != ' ' && *ptrFim != '\0')
        ptrFim--;
    ptrFim++;

    cont = 0;
    while(*ptrFim != '\0' && *ptrFim != ' ')
        palavraInicial[cont++] = *ptrFim++;
    palavraInicial[cont] = '\0';

    frase[0] = '\0';
    strcat(frase, palavraInicial);

    ptrInicio = string + strlen(palavraFinal);
    for(cont = strlen(frase); ptrInicio < &string[n] - strlen(palavraInicial); ptrInicio++, cont++)
        frase[cont] = *ptrInicio;
    frase[cont] = '\0';        

    strcat(frase, palavraFinal);
    puts(frase);
}

int main(){
    char string[MAX];
    fgets(string, MAX, stdin);
    string[strcspn(string, "\n")] = '\0';
    int n = strlen(string);

    if(strcspn(string, " ") != n){
        trocaPalavra(string, n);
    } else puts(string);

    return 0;
}