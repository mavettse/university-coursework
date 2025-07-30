#include <stdio.h>

double raizQuadrada(double y){
    if(y <= 0)
        return 0;

    double xn = y/2, xnum;
    for(int i = 1; i <= 20; i++){
        xnum = (xn + (y/xn))/2;
        xn = xnum;
    }
    return xnum;
}

int main(){
    double y;
    printf("Digite um número real positivo:\n");
    scanf("%lf", &y);

    printf("A raiz quadrada de %g é aproximada ou igual a %g\n", y, raizQuadrada(y));

    return 0;
}
