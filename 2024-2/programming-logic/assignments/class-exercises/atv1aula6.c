#include <stdio.h>

int main(){
    int num;
    printf("Digite um número de 1 a 4 para ver os pratos e 5 para sair: ");
    scanf("%d",&num);

    while(num!=5){
        switch(num){
            case 1:
                printf("Prato 1:\n\tFeijoada Completa\nTradicional prato de feijão preto cozido com carne seca, costelinha de porco e linguiça, servido com arroz branco, farofa, couve refogada e rodelas de laranja.\n");
                break;
            case 2:
                printf("Prato 2:\n\tMoqueca Baiana\nPeixe cozido em leite de coco e azeite de dendê, com pimentões, tomates e coentro. Servido com arroz branco e pirão.\n");
                break;
            case 3:
                printf("Prato 3:\n\tEscondidinho de Carne Seca\nPurê de mandioca cremoso recheado com carne seca desfiada e refogada com cebola e cheiro-verde, coberto com queijo gratinado.\n");
                break;
            case 4:
                printf("Prato 4:\n\tBaião de Dois\nMistura de arroz e feijão verde ou feijão-de-corda com queijo coalho, carne de sol desfiada e temperos nordestinos, servido com torresmo e mandioca cozida.\n");
            default:
                break;
        }
        scanf("%d",&num);
    }

    return 0;
}