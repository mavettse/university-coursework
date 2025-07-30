#include <stdio.h>

void ordenarNumeros(int *maior, int *meio, int *menor){
	int temp;
    if(*maior<*menor){
        temp=*maior;
        *maior=*menor;
        *menor=temp;
    }
    if(*maior<*meio){
        temp=*maior;
        *maior=*meio;
        *meio=temp;
    }
    if(*meio<*menor){
        temp=*meio;
        *meio=*menor;
        *menor=temp;
    }
}

int main(){
    int maior,meio,menor;
    printf("Digite três números: ");
    scanf("%d %d %d",&maior,&meio,&menor);

    ordenarNumeros(&maior,&meio,&menor);

    printf("Ordem crescente: %d %d %d\n",menor,meio,maior);

    return 0;
}