#include <stdio.h>

int main(){
    int a,b,temp;
    printf("Digite dois números: ");
    scanf("%d %d",&a,&b);

    temp=a;
    a=b;
    b=temp;
    
    printf("Troca de valores: %d %d\n",a,b);

    return 0;
}