#include <stdio.h>

int main(){
    int n;
    printf("Digite quantas linhas serão impressas na tela: ");
    scanf("%d",&n);

    if(n>0){
        for(int i=1;i<=n;i++){            
            for(int cont=1;cont<=i;cont++){
                printf("%d",cont);
                if(cont!=i)
                    printf(" ");
            }
            printf("\n");
        }
    }

    return 0;
}