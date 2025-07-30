#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarCaracteres(FILE *arq, char c){
    int n = 0;
    char ch;
    while( (fscanf(arq, "%c", &ch)) != EOF)
        if(ch == c)
            n++;
    return n;
}

int main(){
    char arquivo[100], c;
    FILE *arq;

    printf("Digite o nome do arquivo: ");
    fgets(arquivo, 100, stdin);
    arquivo[strcspn(arquivo,"\n")] = '\0';

    if( (arq = fopen(arquivo, "r")) == NULL){
        printf("Arquivo não encontrado\n");
        return 1;
    } else printf("Arquivo aberto com sucesso\n");

    printf("Digite o caractere que deseja contar: ");
    scanf("%c", &c);
    printf("'%c' aparece %d vez(es) no arquivo\n", c, contarCaracteres(arq, c));
    
    fclose(arq);

    return 0;
}