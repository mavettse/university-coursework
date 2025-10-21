.data
vetor: .word 0:11		# inicializa um vetor com 12 posicoes
input: .asciiz "Insira um numero no vetor: "
output: .asciiz "O valor maximo dentro do vetor é "

.text
main:
	la $a0,input		# insere a mensagem de input em a0
	la $s0,vetor		# salva o endereco do vetor em s0
	add $a1,$zero,$s0	# inicializa a1 com o endereco do vetor; vai armazenar a ultima posicao do vetor apos o loop inicial
	addi $t0,$zero,12	# inicializa t0 com o tamanho do vetor
	add $t1,$zero,$zero	# inicializa t1 com 0 para ser a contadora
	
loop_main: # inicializa o vetor com os valores digitados pelo usuário
	beq $t0,$t1,retorno	# se t1 for igual a t0 (tamanho do vetor), finaliza o loop	
	jal imprimir_string	
	jal ler_int		
	sw $v0,0($a1)		# armazena o valor lido no vetor
	addi $a1,$a1,4		# vai para a proxima posicao do vetor
	addi $t1,$t1,1		# incrementa a contadora
	j loop_main
	
retorno: # label feito para garantir que $ra será direcionado para o fim	
	addi $a1,$a1,-4		# fazendo a1 ir para o endereco da posicao n do vetor
	jal se_1
	
fim: # imprime o maior valor e finaliza o programa
	add $t0,$zero,$v0	# armazena valor maximo (v0) em t0
	la $a0,output		# insere o output em a0
	jal imprimir_string	# imprime a string de saída
	add $a0,$zero,$t0	# atribui o valor maximo (t0) em a0
	jal imprimir_int	# imprime o valor maximo
	addi $v0,$zero,10	# finaliza o programa
	syscall
	
se_1:
	addi $sp,$sp,-8		# insere 2 itens na pilha
	sw $a1,0($sp)		# salva a1 na pilha (endereco da posicao n do vetor)
	sw $ra,4($sp)		# salva ra na pilha
	
	bne $s0,$a1,se_2	# se endereco inicial (s0) != final (a1), pula para se_2
	
	lw $v0,0($a1)		# se não, faz v0 ser igual ao primeiro valor do vetor V[1]
	addi $sp,$sp,8		# retira 2 itens da pilha
	jr $ra			# volta para onde foi chamado
	
se_2:
	addi $a1,$a1,-4		# faz n-1 (volta uma posicao do endereco do vetor)
	jal se_1		# pula para a label se_1 e faz $ra = prox valor
	
	lw $ra,4($sp)		# retira ra da pilha
	lw $a1,0($sp)		# retira a1 da pilha (endereco da posicao n do vetor)
	addi $sp,$sp,8		# retira 2 itens da pilha
	
	lw $t0,0($a1)		# pega o valor V[n] atual do vetor e armazena em t0
	
	slt $t1,$v0,$t0		# se o maximo anterior (v0) for menor que V[n], atribuo V[n] a v0 e retorno
	bne $t1,1,se_2_retorno	
	add $v0,$zero,$t0

se_2_retorno: # retorna para onde foi chamado
	jr $ra

imprimir_string: # imprime uma string e retorna para onde foi chamado
	addi $v0,$zero,4
	syscall
	jr $ra

imprimir_int: # imprime um inteiro e retorna para onde foi chamado
	addi $v0,$zero,1
	syscall
	jr $ra

ler_int: # lê um inteiro e retorna para onde foi chamado
	addi $v0,$zero,5
	syscall
	jr $ra
