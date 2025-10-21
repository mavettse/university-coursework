#include <iostream>
#include <string>

int main (){

	std::string msg;
    std::getline(std::cin, msg);
	std::cout << "Mensagem codificada:\n" << msg << "\nMensagem decodificada:\n";

    int n = msg.size();

    for(int i = 0, j = 0; i < n; i++){

        // desfaz a troca dos blocos de 2
        if(j < (n-1)/2){
            int pos = (n-1) - j - 1;

            std::swap(msg[j], msg[pos]);
            std::swap(msg[j+1], msg[pos+1]);

            // incrementa j para o próximo bloco
            j+=4;
        } 
  
        // desfaz a troca entre as letras dos´blocos
        if(i%2 == 0 && i < n-1){
            std::swap(msg[i], msg[i+1]);
        }

        // transforma os '#' em ' '
        if(msg[i] == 35){
            msg[i] = 32;
        } else {
            // desfaz a cifra de césar com as 5 letras
            msg[i] -= 5;
            
            // vê se o caractere está fora da range das letras na tabela ascii 
            if(msg[i] < 65 || (msg[i] > 90 && msg[i] < 97)){
                msg[i] += 26;
            }
        }
    }

    // imprime a mensagem descriptograda
    std::cout << msg << "\n";

    return 0;
}