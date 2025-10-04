#include <iostream>
#include <vector>
#include <algorithm>

// estrutura de item com seus atributos: peso e valor
struct Item{
        int peso, valor;
    };

// função recursiva para calcular o valor máximo com programação dinâmica
int ValorMaximo(const std::vector<Item>& itens, int numitens, int capacidade){
    
    // se zerar a quantidade de itens ou a capacidade total, retorna 0
    if(numitens == 0 || capacidade == 0){
        return 0;
    }

    // se o peso de um item for maior do que a capacidade máxima da mochila, chama a função novamente com o item anterior
    if(itens[numitens - 1].peso > capacidade){
        return ValorMaximo(itens, numitens-1, capacidade);
    }

    // retorna o valor máximo entre a o valor maximo anterior e o valor maximo do anterior se o item atual for adicionado
    return std::max(ValorMaximo(itens, numitens-1, capacidade), itens[numitens-1].valor + ValorMaximo(itens, numitens-1, capacidade-itens[numitens-1].peso));
}

int main(){

    // leitura inicial do peso, criação de vetor com os itens e de vetor com a solução digitada
    int capacidade, numitens;

    std::cin >> capacidade >> numitens;

    std::vector<Item> itens(numitens);
    std::vector<Item> solucaousuario(1);

    for(int i = 0; i < numitens; ++i){
        std::cin >> itens[i].peso >> itens[i].valor;
    }

    // soma os valores da solução inserida pelo usuário
    for(int i = 0; i < numitens; ++i){
        int n;
        std::cin >> n;

        if(n){
            solucaousuario[0].peso += itens[i].peso;
            solucaousuario[0].valor += itens[i].valor;
        }
    }

    // verifica se é solução inviável
    if(solucaousuario[0].peso > capacidade){
        std::cout << "Solucao inviavel.\n";
        return 0;
    }

    // se for viável, calcula a solução ótima
    int valorMaximo = ValorMaximo(itens, numitens, capacidade);
    
    // se o valor da solução ótima for maior que a solucao do usuario, 
    if(valorMaximo > solucaousuario[0].valor){
        std::cout << "Solucao viavel mas nao otima.\n";
    } else {
        std::cout << "Solucao otima.\n";
    }

    return 0;
}