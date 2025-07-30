#include <stdio.h>

int main(){

    int num,numinv=0;
    printf("Digite um número: ");
    scanf("%d",&num);

    while(num>0){
        numinv+=num%10;
        num/=10;
        if(num>0)
            numinv*=10;
    }

    printf("Número invertido: %d\n",numinv);

    return 0;
}