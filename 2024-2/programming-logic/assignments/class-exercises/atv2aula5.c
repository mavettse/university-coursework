#include <stdio.h>

void imprimeMaior(int num[3]){
	int maior=num[0];
	for(int i=1;i<3;i++){
		if(num[i]>maior)
			maior=num[i];
	}
	printf("O maior número é: %d\n",maior);
}

int main(){
    int num[3];
    printf("Digite 3 números: ");
    for(int i=0;i<3;i++){
        scanf("%d",&num[i]);
    }

    imprimeMaior(num);
    return 0;
}