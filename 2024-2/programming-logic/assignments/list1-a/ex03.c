#include <stdio.h>

int main(){
    int num;
    printf("Digite um número qualquer: ");
    scanf("%d",&num);

    num/=10;
    if(num>9)
        num%=10;
    printf("O algarismo da dezena é %d\n",num);

    return 0;
}