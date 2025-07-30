#include <stdio.h>

int inverteNum(int i){
    int invertido = 0;
    while(i != 0){
        invertido = invertido * 10 + (i % 10);
        i /= 10;
    }
    return invertido;
}

int main() {
    for(int i = 0; i <= 10000; i++){
        if(i == inverteNum(i))
            printf("%d\n",i);
    }

    return 0;
}