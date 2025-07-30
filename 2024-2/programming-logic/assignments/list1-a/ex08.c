#include <stdio.h>

int main(){
    double d,l,v,t;
    printf("Digite o tempo e a velocidade média da viagem: ");
    scanf("%lf %lf",&t,&v);

    d=v*t; 
    l=d/12;
    
    printf("Distância: %g\nLitros: %g\n",d,l);

    return 0;
}