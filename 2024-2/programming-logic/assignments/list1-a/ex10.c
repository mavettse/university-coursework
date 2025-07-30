#include <stdio.h>

int main(){
    int fib0=0,fib1=1,fibn=0,n;
    printf("Digite o n-ésimo termo da sequência fibonacci: ");
    scanf("%d",&n);

    for(int i=0;i<n;i++){
        fib0=fib1;
        fib1=fibn;
        fibn=fib0+fib1;
    }

    printf("fib(%d) = %d\n",n,fibn);

    return 0;
}