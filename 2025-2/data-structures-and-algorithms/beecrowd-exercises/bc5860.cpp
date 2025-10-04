#include <iostream>
#include <string>

// função recursiva para decompor número
void decomporNumero(int maximo, int decompor, std::string decomposicao){
    // imprime a string e retorna com quebra de linha se o número a ser decomposto chegar a zero
    if(decompor == 0){
        std::cout << decomposicao + "\n";
        return;
    }

    // laço para iterar de n a 1
    for(int i = maximo; i > 0; --i){

        // se o número a ser decomposto for maior ou igaul a iteração atual, altera a string e faz a recursão
        if(decompor >= i){
            std::string nova_decomposicao = decomposicao.empty() ? std::to_string(i) : decomposicao + " + " + std::to_string(i);
            decomporNumero(i, decompor - i, nova_decomposicao);
        }
    }
}

int main(){
    // leitura do numero que será decomposto
    int n;
    std::cin >> n;    

    // impressão da string de saída e chamada da função
    std::cout << "Decomposicao:\n";
    decomporNumero(n,n,""); 

    return 0;
}