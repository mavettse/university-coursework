#include <stdio.h>
#include <string.h>

#define MAX 40

void reverse(char s[]){
    if(*s != '\0') {
        reverse(s + 1);
        putchar(*s);
    }
}

int main(){
    char string[MAX];
    fgets(string, MAX, stdin);
    string[strcspn(string, "\n")] = '\0';

    reverse(string);
    printf("\n");

    return 0;
}