#include <stdio.h>

int main(){
    int n,x0,cont=0,i=0;
    printf("Digite quantos números serão digitados: ");
    scanf("%d",&n);
    if(n<2)
        return 1;
    int x[n];

    printf("Digite uma sequência de %d números: ",n);
    for(i=0;i<n;i++){
        scanf("%d",&x[i]);
    }

    x0=x[0];
    for(i=1;i<n;i++){
        if(x0<=x[i])
            cont++;
        x0=x[i];
    }

    if(cont==n-1)
        printf("Os números estão ordenados.\n");
    else printf("Os números não estão ordenados.\n");

    return 0;
}