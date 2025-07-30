#include <stdio.h>

int main() {
    int n;
    scanf("%d",&n);

    if(n>0 && n<=50){
        double s=0;
        int den = n-1;
        for(int i=1;i<n;i++){
            s+=(i*(i+1))/(double)den--;
        }
        printf("S = %g\n",s);
    }

    return 0;
}