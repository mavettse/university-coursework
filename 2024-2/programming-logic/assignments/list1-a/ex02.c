#include <stdio.h>

int main(){
    int num;
    printf("Digite um número: ");
    scanf("%d",&num);
    printf("Sucessor: %d\nAntecessor: %d\n",num+1,num-1);

    return 0;
}