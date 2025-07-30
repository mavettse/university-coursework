#include <stdio.h>

int mdcCalculo(int m, int n){
    if(m<n){
        int temp=m;
        m=n;
        n=temp;
    }
    if(n==0)
        return m;
    else {
        int temp;
        while(n!=0){
            temp=n;
            n=m%n;
            m=temp;
        }
        return m;
    }
}

int main(){
    int m,n,mdc;
    printf("Digite dois números: ");
    scanf("%d %d",&m,&n);

    mdc=mdcCalculo(m,n);

    printf("O máximo divisor comum de %d e %d é %d\n",m,n,mdc);

    return 0;
}