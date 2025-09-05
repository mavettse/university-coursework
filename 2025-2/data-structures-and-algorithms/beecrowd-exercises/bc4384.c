#include <stdio.h>

int mult(int base, int exp){
    
    if(exp > 0){
        return base * mult(base, exp-1);
    } else if(exp == 0){
        return 1;
    }
    
    return base;
}
 
int main() {
    
    int base, exp;
    
    printf("Digite a base e o expoente inteiros: ");
    scanf("%d%d", &base, &exp);
 
    printf("Resultado: %d\n", mult(base, exp));

    return 0;
}