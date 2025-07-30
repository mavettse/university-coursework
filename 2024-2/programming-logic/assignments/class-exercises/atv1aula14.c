#include <stdio.h>

int main(){
    int a, *b = &a, **c = &b, ***d = &c;
    scanf("%d", &a);

    printf("Dobro: %d\nTriplo: %d\nQuádruplo: %d\n", 2*(*b), 3*(**c), 4*(***d));

    return 0;
}