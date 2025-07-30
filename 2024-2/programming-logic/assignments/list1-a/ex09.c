#include <stdio.h>

int main(){
    double sal,qtkw,valor;
    printf("Digite o salário mínimo e a quantidade de quilowatts gasta na residência: ");
    scanf("%lf %lf",&sal,&qtkw);

    valor=(qtkw*(sal/7))/100;
    printf("O valor da conta será R$ %.2lf\n",valor);

    return 0;
}