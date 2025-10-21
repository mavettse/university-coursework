#include <iostream>
#include <string>

int main (){

	std::string msg;
    std::getline(std::cin, msg);
	std::cout << "Mensagem codificada:\n" << msg << "\nMensagem decodificada:\n";

// se tamanho da string for impar, insere um espaço no final
if(msg.size() % 2 != 0){
	msg.push_back(' ');
}

// pega o tamanho da string
int tamanhomsg = msg.size();

for(int i = 0; i < tamanhomsg; ++i){

	// substitui ' ' por '#'
	if(msg[i] == 32){
		msg[i] = 35;
	} else {
		msg[i]+=5;	
	}
	
}

std::cout << msg;

return 0;

}