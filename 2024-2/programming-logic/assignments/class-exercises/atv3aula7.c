#include <stdio.h>

int binario(int num){
    if(num<=0)
        return 0;
    int binario=0;
    int potencia=1;
    while(num!=0){
        binario+=(potencia*(num%2));
        potencia*=10;
        num/=2;
    }
    return binario;
}

int main(){
    int num,bin;
    printf("Digite um número positivo: ");
    scanf("%d",&num);

    bin=binario(num);
    printf("Número em decimal: %d\nNúmero em binário: %d\n",num,bin);

    return 0;
}