#include <stdio.h>

int main(){
    int num,soma=0;
    printf("Digite um número: ");
    scanf("%d",&num);

    for(int i=1;i<=num;i++){ //não sei se o número limite deve entrar na soma, mas vou supor que sim
        if(i%2!=0)
            soma+=i;
    }

    printf("A soma de todos os números ímpares entre 1 e %d é %d\n",num,soma);

    return 0;
}