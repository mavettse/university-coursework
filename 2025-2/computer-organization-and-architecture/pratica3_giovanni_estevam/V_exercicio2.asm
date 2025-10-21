.data
msg: .asciiz "Digite um numero: "
espaco: .asciiz " "

.text

main: # imprime mensagem, lê o inteiro digitado pelo usuário, armazena-o em $a0 e utiliza jal na lógica para $ra = fim
	la $a0,msg
	jal imprimir_string
	jal ler_int
	
	add $a0,$zero,$v0
	
	jal imp_ordem_decrescente

fim: # fim do programa principal
	addi $v0,$zero,10
	syscall

imp_ordem_decrescente:
	addi $sp,$sp,-4			# armazena $ra = fim na pilha
	sw $ra,0($sp)
	
if:
	slt $t0,$zero,$a0		# se 0 < n, imprime o número, decrementa n e chama a função novamente
	beq $t0,$zero,limpar_pilhas
	
	add $t0,$zero,$a0		# armazena a0 (n) em um registrador temporário
	
	jal imprimir_int		# imprime o n e o espaco
	la $a0,espaco
	jal imprimir_string
	
	add $a0,$zero,$t0		# pega o a0 armazenado e o decrementa
	addi $a0,$a0,-1

	jal imp_ordem_decrescente
	
limpar_pilhas:
	lw $ra,0($sp)			# retira o valor armazenado na pilha e volta para onde foi chamado
	addi $sp,$sp,4
	jr $ra	
			
ler_int: # lê um inteiro e o armazena em v0
	addi $v0,$zero,5
	syscall
	jr $ra

imprimir_string: # imprime a string armazenada em a0
	addi $v0,$zero,4
	syscall
	jr $ra

imprimir_int: # imprime o número armazenado em a0
	addi $v0,$zero,1
	syscall
	jr $ra