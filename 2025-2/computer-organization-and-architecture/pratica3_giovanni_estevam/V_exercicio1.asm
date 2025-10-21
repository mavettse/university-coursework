.data

# MENSAGENS DO MENU
menu_msg: .asciiz "\n\n---- MENU DE OPÇÕES ----\n"
opcao1_msg: .asciiz "1. Compara números\n"
opcao2_msg: .asciiz "2. Ordena 3 números\n"
opcao3_msg: .asciiz "3. Somatório\n"
opcao4_msg: .asciiz "4. Sequência\n"
sair_msg: .asciiz "5. Sair\n\n"

# MENSAGENS DE INTERAÇÃO
prompt: .asciiz "Escolha uma opção: "
pede_n1: .asciiz "\nDigite o 1o número: "
pede_n2: .asciiz "Digite o 2o número: "
pede_n3: .asciiz "Digite o 3o número: "
pede_num: .asciiz "\nDigite um número: "
resultado: .asciiz "\nO resultado é: "
ordenacao: .asciiz "\nOrdem decrescente: "
sequencia: .asciiz "\nA sequência é: "
nova_linha: .asciiz "\n"
espaco: .asciiz " "

.text

menu: # imprime opções, lê entrada e pula para a selecionada
	la $a0,menu_msg				# imprime as opcoes do menu
	jal imprimir_string
	la $a0,opcao1_msg
	jal imprimir_string
	la $a0,opcao2_msg
	jal imprimir_string
	la $a0,opcao3_msg
	jal imprimir_string
	la $a0,opcao4_msg
	jal imprimir_string
	la $a0,sair_msg
	jal imprimir_string
	la $a0,prompt
	jal imprimir_string
	
	jal ler_int
	
	beq $v0,1,opcao1			# pula para a opcao escolhida
	beq $v0,2,opcao2
	beq $v0,3,opcao3
	beq $v0,4,opcao4
	beq $v0,5,finalizar_programa
	
	j menu				# se foi inserido uma opcao invalida, reinicia o loop

# retira $ra da pilha e encerra a execução	
finalizar_programa:
	addi $sp,$sp,4
	addi $v0,$zero,10
	syscall


# ---- ROTINA 1 ----

# $s0 = 1o numero
# $s1 = 2o numero
# $s2 = maior - menor

opcao1:
	jal pedir_2_num
	jal rotina1
	j menu

rotina1: # armazena os valores anteriores de s0, s1, s2 e ra na pilha
	addi $sp,$sp,-16
	sw $s2,12($sp)
	sw $s1,8($sp)
	sw $s0,4($sp)
	sw $ra,0($sp)
	
	# armazena os numeros digitados pelo usuario em s0 e s1
	add $s0,$zero,$a0
	add $s1,$zero,$a1
	
	# armazena os valores atuais na pilha
	addi $sp,$sp,-8
	sw $s0,4($sp)
	sw $s1,0($sp)
	
	# se s0 < s1, para fazer a subtração do maior pelo menor
	slt $t0,$s0,$s1				
	bne $t0,$zero,rotina1_troca
	
rotina1_sub: # subtrai o maior pelo menor e armazena em s2
	sub $s2,$s0,$s1				# faz a subtração
	
	lw $s1,0($sp)				# retira s0 e s1 atuais da pilha
	lw $s0,4($sp)
	addi $sp,$sp,8
	
	# s0 > sub ? 1 : 0	
	la $a0,resultado			# imprime o resultado
	jal imprimir_string

	slt $a0,$s2,$s0				# armazena o resultado em a0 
	jal imprimir_int	
		
	lw $ra,0($sp)				# retira ra, s0, s1 e s2 anteriores da pilha
	lw $s0,4($sp)
	lw $s1,8($sp)				
	lw $s2,12($sp)
	addi $sp,$sp,16
	
	jr $ra					# retorna para o chamador
	
rotina1_troca: # troca s0 e s1 de lugar
	add $t0,$zero,$s0
	add $s0,$zero,$s1
	add $s1,$zero,$t0
	
	j rotina1_sub				# faz a troca e pula pra subtração	


# ---- ROTINA 2 ----

# $s0 = 1o numero
# $s1 = 2o numero
# $s3 = 3o numero

opcao2: # imprime as mensagens de input 
	jal pedir_3_num
	jal rotina2
	j menu

rotina2: # armazena os valores anteriores de s0, s1, s2 e ra na pilha
	addi $sp,$sp,-16
	sw $s2,12($sp)
	sw $s1,8($sp)
	sw $s0,4($sp)
	sw $ra,0($sp)

	# armazena os numeros digitados pelo usuario em s0, s1 e s2
	add $s0,$zero,$a0
	add $s1,$zero,$a1
	add $s2,$zero,$a2
	
rotina2_condicional: # faz os condicionais e pula para os respectivos blocos
	slt $t0,$s0,$s1				# se s0 < s1, troca os valores de s0 com s1
	bne $t0,$zero,num1_troca_num2
	
	slt $t0,$s1,$s2				# se s1 < s2, troca os valores de s1 com s2
	bne $t0,$zero,num2_troca_num3 		
	
	slt $t0,$s0,$s2				# se s0 < s2, troca os valores de s0 com s2
	bne $t0,$zero,num1_troca_num3 		
	
	# se nenhuma das condicoes foram atendidas, os blocos ja estao ordenados
		
rotina2_saida: # imprime as strings e os numeros em ordem descrescente s0 > s1 > s2
	la $a0,ordenacao
	jal imprimir_string
	
	add $a0,$zero,$s0
	jal imprimir_int
	la $a0,espaco
	jal imprimir_string
	
	add $a0,$zero,$s1
	jal imprimir_int
	la $a0,espaco
	jal imprimir_string
	
	add $a0,$zero,$s2
	jal imprimir_int
	la $a0,espaco
	jal imprimir_string
	
	# retira os itens da pilha e volta para onde foi chamado
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)				
	lw $s2,12($sp)
	addi $sp,$sp,16
	
	jr $ra					# retorna para onde foi chamado
	
num1_troca_num2: # troca os valores para ficar s0 > s1
	add $t0,$zero,$s0
	add $s0,$zero,$s1
	add $s1,$zero,$t0
	j rotina2_condicional			
	
num2_troca_num3: # troca os valores para ficar s1 > s2
	add $t0,$zero,$s1
	add $s1,$zero,$s2
	add $s2,$zero,$t0
	j rotina2_condicional	

num1_troca_num3: # troca os valores para ficar s0 > s2
	add $t0,$zero,$s0
	add $s0,$zero,$s2
	add $s2,$zero,$t0
	j rotina2_condicional


# ---- ROTINA 3 ----

# $s0 = soma
# $s1 = numero digitado - 1

opcao3:
	jal pedir_num
	jal rotina3
	j menu
	
rotina3: # armazena os valores anteriores de s0, s1 e ra na pilha
	addi $sp,$sp,-12
	sw $s1,8($sp)
	sw $s0,4($sp)
	sw $ra,0($sp)
	
	# inicializa s0 com 0 e s1 com o número digitado - 1
	add $s0,$zero,$zero
	add $s1,$zero,$a0
	addi $s1,$s1,-1

rotina3_loop: # faz o somatorio		
	slt $t0,$zero,$s1			# se o número for menor ou igual a zero, finaliza
	beq $t0,$zero,rotina3_saida			
	
	add $s0,$s0,$s1				# incrementa o somatório e decrementa o número
	addi $s1,$s1,-1
	
	j rotina3_loop

rotina3_saida: # imprime a resposta e retorna para onde foi chamado
	la $a0,resultado
	jal imprimir_string
	
	add $a0,$zero,$s0
	jal imprimir_int
	
	# retira os itens da pilha
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)				
	addi $sp,$sp,12
	
	jr $ra					# retorna 
	

.text

# ---- ROTINA 4 ----

# $s0 = termo atual
# $s1 = numero digitado

opcao4:
	jal pedir_num
	jal rotina4
	j menu

rotina4: # armazena os valores anteriores de s0, s1 e ra na pilha
	addi $sp,$sp,-12
	sw $s1,8($sp)
	sw $s0,4($sp)
	sw $ra,0($sp)
	
	# inicializa s1 com o número digitado e s0 com 0 ou 1, a depender da entrada
	add $s1,$zero,$a0
	slt $s0,$zero,$s1
	
	beq $s0,$zero,rotina4_saida			# se s0 = 0, pula para a saída
	
	la $a0,sequencia				# se não, imprime a mensagem de início da sequência
	jal imprimir_string
	
rotina4_loop: # faz a sequencia
	beq $s1,$zero,rotina4_saida			# quando s1 chegar a 0, finaliza a sequencia
	beq $s0,3,rotina4_menos1			# decrementa 1 no termo da sequência quando chega a 3 para corrigir
	
	add $a0,$zero,$s0				# imprime um termo da sequencia
	jal imprimir_int
	la $a0,espaco
	jal imprimir_string
	
	addi $s0,$s0,2					# incrementa 2 no termo atual
	addi $s1,$s1,-1					# decrementa 1 no numero digitado
	
	j rotina4_loop
	
rotina4_menos1:
	addi $s0,$s0,-1
	j rotina4_loop

rotina4_saida: # retira os itens da pilha e volta para onde foi chamado
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)				
	addi $sp,$sp,12
	
	jr $ra					# retorna para onde foi chamado


# ---- FUNÇÕES AUXILIARES ----

pedir_3_num: # pede tres números e armazena-os em a0, a1 e a2
	la $a0,pede_n1				# pede e armazena o 1o numero em t0
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $t0,$zero,$v0
	
	la $a0,pede_n2				# pede e armazena o 2o numero em a1
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $a1,$zero,$v0
	
	la $a0,pede_n3				# pede e armazena o 3o numero em a2
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $a2,$zero,$v0
	
	add $a0,$zero,$t0			# faz a0 = 1o numero
	jr $ra					# volta para onde foi chamado
	
pedir_2_num: # pede dois números e armazena-os em a0 e a1
	la $a0,pede_n1				# pede e armazena o 1o numero em t0
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $t0,$zero,$v0
	
	la $a0,pede_n2				# pede e armazena o 2o numero em a1
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $a1,$zero,$v0
	
	add $a0,$zero,$t0			# faz a0 = 1o numero
	jr $ra					# volta para onde foi chamado

pedir_num: # pede um número e armazena-o em a0
	la $a0,pede_num				# pede e armazena o numero em a0
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	
	add $a0,$zero,$v0
	jr $ra					# volta para onde foi chamado

imprimir_string: # imprime a string em $a0
	addi $v0,$zero,4
	syscall
	jr $ra

imprimir_int: # imprime o inteiro em $a0
	addi $v0,$zero,1
	syscall
	jr $ra
	
ler_int: # lê um inteiro e o armazena em $v0	
	addi $v0,$zero,5
	syscall
	jr $ra	