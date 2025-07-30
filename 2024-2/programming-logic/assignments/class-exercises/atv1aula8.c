#include <stdio.h>

long fat(long n){
    if(n <= 0)
        return 1;

    long fatorial = 1;
    for(int i = 1; i <= n; i++){
        fatorial *= i;
    }

    return fatorial;
}

int main(){
    for(long n = 1; n <= 20; n++){
        printf("%ld! = %ld\n", n, fat(n));
    }

    return 0;
}
