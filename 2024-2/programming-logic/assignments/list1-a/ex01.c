#include <stdio.h>

int main(){
    int a1,r,n,an;
    printf("Digite, respectivamente, a razão e o primeiro termo da P.A.: ");
    scanf("%d %d",&r,&a1);

    printf("Você deseja saber o termo de qual posição?\n");
    scanf("%d",&n);

    an=a1+(n-1)*r;
    printf("O %dº termo da progressão aritmética é %d\n",n,an);

    return 0;
}