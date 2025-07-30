#include <stdio.h>

int divisaoInteiros(int a, int b, int c){
    a-=b; c++;
    if(a >= 0)
        return divisaoInteiros(a, b, c);
    else return c - 1;
}

int main(){
    int a, b, c = 0;
    scanf("%d %d", &a, &b);

    printf("O inteiro divisor entre %d e %d é %d\n", a, b, divisaoInteiros(a,b,c));

    return 0;
}