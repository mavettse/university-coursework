#include <stdio.h>

int main(){
    double c,f;
    printf("Digite a temperatura em Celsius: ");
    scanf("%lf",&c);
    
    f=((9*c)+160)/5;
    printf("Temperatura em Fahrenheit: %g\n",f);

    return 0;
}