#include <stdio.h>
#include <limits.h>
 
int main() {
    // lendo o número de camadas de caixas
    int n;
    scanf("%d", &n);

    // inicializando a matriz caixas e lendo as entradas digitadas pelo usuário
    int caixas[n][n];
    for(int i = 0; i < n; ++i){
        for(int j = 0; j <= i; ++j){
            scanf("%d", &caixas[i][j]);
        }
    }    

    // criando a variável max (que armazenará o valor máximo) e as variaveis camada e caixa
    int max = caixas[0][0];
    int camada = 1;
    int caixa = 1;

    // inicializando o vetor tot que armazenará o valor da soma de todas as colunas acima da atual
    int tot[n]; 
    for(int i = 1; i < n; ++i){
        tot[i] = 0;
    }
    tot[0] = max;


    // loop que faz a verificação para encontrar o máximo
    for(int i = 1; i < n; ++i){
        int tempMax = INT_MIN;
        int tempCamada = i + 1;
        int tempCaixa = -1;

        for(int j = 0; j <= i; ++j){
            // verifica e altera o valor de tempMax se ela não tiver o maior valor da camada atual
            if(tempMax < caixas[i][j]){
                tempMax = caixas[i][j];
                tempCaixa = j+1;
            }

            // soma o valor da caixa atual no vetor tot
            tot[i] += caixas[i][j];
        }

        // soma o valor da coluna anterior na coluna atual
        tot[i] += tot[i-1];

        // altera o valor da variavel max se esta for menor que a soma de todas as camadas anteriores com o maior valor da camada atual
        if(max < (tot[i-1] + tempMax)){
            max = tot[i-1] + tempMax;
            camada = tempCamada;
            caixa = tempCaixa;
        }
    } 

    printf("Resposta: camada %d, caixa %d.\n", camada, caixa);

    return 0;
}