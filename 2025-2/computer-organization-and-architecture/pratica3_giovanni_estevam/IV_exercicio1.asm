.data
input: .asciiz "Digite um numero: "
output: .asciiz "O resultado é "

.text
main: # imprime a entrada, faz a leitura de N e o armazena em a0 e em v0
	la $a0,input
	jal imprimir_string
	jal ler_int
	add $a0,$zero,$v0
	jal F
	
fim: # imprime a string de saída, o resultado de F e finaliza o programa
	add $s0,$zero,$v0	# armazena o resultado em s0
	la $a0,output
	jal imprimir_string
	add $a0,$zero,$s0	# pega o resultado salvo em s0 e o imprime
	jal imprimir_int
	addi $v0,$zero,10
	syscall

F: # label para a funcao F
	addi $sp,$sp,-8		# insere 2 itens na pilha
	sw $a0,0($sp)		# salva a0 na pilha
	sw $ra,4($sp)		# salva ra na pilha

	slti $t0,$a0,4		# se N >= 4, pula para o else
	beq $t0,$zero,else
	
if: # label para o caso em que N < 4
	addi $a1,$zero,3
	jal multiplica		# faz a multiplicacao N * 3 (fica salva em v0)
	j limpar_pilha

else: # trata o caso N >= 4
	addi $a0,$a0,-4		
	jal F			# faz o F(N-4)
	
	add $a0,$zero,$v0	# salva o valor atual de v0 em a0
	
	addi $a1,$zero,2
	jal multiplica		#  F(N-4) * 2 e armazena em v0
	add $v0,$v0,5		# 5 + (F(N-4) * 2) e armazena em v0
	
limpar_pilha:
	lw $ra,4($sp)		# retira ra da pilha
	lw $a0,0($sp)		# retira a0 da pilha
	addi $sp,$sp,8		# retira 2 itens da pilha
	jr $ra			# volta para onde foi chamado

multiplica: # inicializa t0 com zero
	add $t0,$zero,$zero
	
multiplica_loop: # loop para fazer a multiplicacao 
	beq $a1,$zero,multiplica_retorno	# se a1 for zero, sai da multiplicacao
	add $t0,$t0,$a0		# faz a multiplicacao 
	addi $a1,$a1,-1		# decrementa a1 (o 2o numero)
	j multiplica_loop
	
multiplica_retorno: # atribui o valor da multiplicacao a v0 e retorna para onde foi chamamdo 
	add $v0,$zero,$t0
	jr $ra
	
imprimir_int: # imprime o numero armazenado em $a0
	add $a0,$zero,$s0
	addi $v0,$zero,1
	syscall
	jr $ra
	
imprimir_string: # imprime a string armazenada em $a0
	addi $v0,$zero,4
	syscall
	jr $ra

ler_int: # lê o inteiro e o armazena em v0
	addi $v0,$zero,5
	syscall
	jr $ra