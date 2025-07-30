#include <stdio.h>
#include <math.h>

int main(){
    int n, x;
    printf("Digite o número de termos e um valor positivo: ");
    scanf("%d %d",&n,&x);

    int sinal=-1,fatorial[4]={6,2,1,2},expoente=2;
    double s=0;

    for(int i=0;i<n;i++){
        s += sinal*((pow(x,expoente))/fatorial[expoente%4]);
        sinal*=-1;
        expoente+=1;
    }

    printf("Resultado = %g\n",s);

    return 0;
}