#include <stdio.h>

int main(){
    double a,b;
    printf("Digite dois números: ");
    scanf("%lf %lf",&a,&b);

    printf("Soma: %g\nSubtração: %g\nMultiplicação: %g\n",a+b,a-b,a*b);
    if(b!=0)
        printf("Divisão: %g\n",a/b);
    else printf("Divisão impossível. Denominador = 0.\n");

    return 0;
}