#include <stdio.h>

int main(){
    int n,primo[6]={1,1,1,1,1,1},maior=1,fatb[6]={2,3,5,7,11,13},fate[6]={0},base,expoente;
    scanf("%d",&n);

    while(n%2==0 && n>0){
        primo[0]*=2; n/=2; fate[0]++;
    }
    while(n%3==0 && n>0){
        primo[1]*=3; n/=3; fate[1]++; 
    }
    while(n%5==0 && n>0){
        primo[2]*=5; n/=5; fate[2]++;
    }
    while(n%7==0 && n>0){
        primo[3]*=7; n/=7; fate[3]++;
    }
    while(n%11==0 && n>0){
        primo[4]*=11; n/=11; fate[4]++;
    }
    while(n%13==0 && n>0){
        primo[5]*=13; n/=13; fate[5]++;
    }

    for(int i=0;i<6;i++){
        if(primo[i]>maior) {
            maior=primo[i];
            base=fatb[i];
            expoente=fate[i];
        }
    }

    printf("%d = %d^%d\n",maior,base,expoente);
    return 0;
}