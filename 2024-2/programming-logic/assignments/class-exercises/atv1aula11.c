#include <stdio.h>
#include <string.h>
#include <locale.h>

void tiraEspaco(char* string){
    int i, j = 0;
    for(i = 0; string[i] != '\0'; i++)
        if(string[i] != ' ')
            string[j++] = string[i];
    string[j] = '\0';
}

void tiraAcento(char* string) {
    char* acentuados = "áàãâäÁÀÃÂÄéèêëÉÈÊËíìîïÍÌÎÏóòõôöÓÒÕÔÖúùûüÚÙÛÜçÇ";
    char* semAcento = "aaaaaaaaaaeeeeeeeeiiiiiiiioooooooooouuuuuuuucc";

    for (int i = 0; string[i] != '\0'; ++i) {
        char* posicao = strchr(acentuados, string[i]);
        if(posicao)
            string[i] = semAcento[posicao - acentuados];
    }
}

void tiraCaps(char* string){
    for(int i = 0; string[i] != '\0'; ++i)
        if(string[i] >= 65 && string[i] <= 90)
            string[i] += 32;
}

void inverteString(char* string) {
    int len = strlen(string);
    char temp;
    for (int i = 0; i < len / 2; ++i) {
        temp = string[i];
        string[i] = string[len - i - 1];
        string[len - i - 1] = temp;
    }
}

void verificaPalindromo(char* string) {
    tiraEspaco(string);
    tiraAcento(string);
    tiraCaps(string);

    char original[51];
    strcpy(original, string);

    char invertida[51];
    strcpy(invertida, string);
    inverteString(invertida);

    if (strcmp(original, invertida) == 0)
        printf("Palindromo\n");
    else printf("Nao Palindromo\n");
}

int main(){
    setlocale(LC_ALL, "pt_BR.UTF-8");
    char string[51];
    fgets(string, 51, stdin);

    string[strcspn(string, "\n")] = '\0';

    verificaPalindromo(string);
    
    return 0;
}