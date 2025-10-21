.data
msg_input: .asciiz "Entre com um número: "

msg1_output: .asciiz "A série de Fibonacci para "
msg2_output: .asciiz " elementos é:\n"
msg3_output: .asciiz "\nOk"

espaco: .asciiz ", "

.text

main: # imprime mensagens iniciais e armazena o valor de n
	la $a0,msg_input			# pede para o usuário digitar um número e o armazena em s0
	jal imprimir_string
	jal ler_int
	add $s0,$zero,$v0
	
	la $a0,msg1_output			# imprime mensagens
	jal imprimir_string
	add $a0,$zero,$s0
	jal imprimir_int
	la $a0,msg2_output
	jal imprimir_string
	
	addi $s0,$s0,1				# incrementa 1 em n (para facilitar o for)
	addi $s1,$zero,1			# inicializa um registrador contador com 1
	
for:	
	slt $t0,$s1,$s0			# se contadora < n+1, procede
	beq $t0,$zero,fim
	
	add $a0,$zero,$s1			# inicializa a0 = s1 e v0 = 0
	add $v0,$zero,$zero			
	
	jal fibonacci				# faz o cálculo
	jal imprimir_fib			# imprime o resultado 
	
	addi $s1,$s1,1				# incrementa a contadora s1
	j for					# retorna para o for
	
fim: # finaliza o programa
	la $a0,msg3_output			# imprime mensagem de output
	jal imprimir_string
	
	addi $v0,$zero,10
	syscall

fibonacci:
	beq $a0,1,return_1			# se a0 (n) = 1, retorna 1
	beq $a0,2,return_1			# se a0 (n) = 2, retorna 1
	
	addi $sp,$sp,-8				# armazena ra e a0 na pilha
	sw $ra,4($sp)
	sw $a0,0($sp)

	addi $a0,$a0,-1				# faz fibonacci(n-1)
	jal fibonacci
		
	lw $a0,0($sp)				# resgata a0 da pilha e adiciona o v0 (fib(n-1)) no seu lugar
	sw $v0,0($sp)
	
	addi $a0,$a0,-2				# faz fibonacci(n-2)
	jal fibonacci
	
	add $t0,$v0,$zero			# armazena v0 (fibonacci(n-2)) em um registrador temporário
	
	lw $v0,0($sp)				# resgata os valores de fibonacci(n-1) e de ra salvos na pilha
	lw $ra,4($sp)
	addi $sp,$sp,8
	
	add $v0,$v0,$t0				# faz v0 = fibonacci(n-1) + fibonacci(n-2)
	
	jr $ra					# volta para onde foi chamado
	
return_1: # retorna 1
	addi $v0,$zero,1
	jr $ra
	
imprimir_fib: # imprime o atual valor de v0 e insere um espaco
	addi $sp,$sp,-4				# adiciona ra na pilha
	sw $ra,0($sp)
	
	add $a0,$zero,$v0			# imprime o valor atual de v0 e adiciona um espaco
	jal imprimir_int
	la $a0,espaco
	jal imprimir_string	
	
	lw $ra,0($sp)				# retira ra da pilha
	addi $sp,$sp,4
	
	jr $ra					# volta para onde foi chamada
	
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
