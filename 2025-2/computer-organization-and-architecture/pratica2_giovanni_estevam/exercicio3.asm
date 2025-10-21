.data	
input1: .asciiz "Digite o 1o numero: "
input2: .asciiz "Digite o 2o numero: "
input3: .asciiz "Digite o 3o numero: "
espaco: .asciiz " "
ordenacao: .asciiz "Ordem decrescente: "

.text
# imprime as strings e lê os números digitados pelo usuário
input:
	# imprime string, lê e armazena o primeiro numero em $s1
	la $a0,input1
	jal imprime_string
	jal le_int
	add $s1,$zero,$v0
	
	# imprime string, lê e armazena o 2o numero em $s2
	la $a0,input2
	jal imprime_string
	jal le_int	
	add $s2,$zero,$v0
	
	# imprime string, lê e armazena o 3o numero em $s3
	la $a0,input3
	jal imprime_string
	jal le_int
	add $s3,$zero,$v0
	
condicional:
	slt $t0,$s1,$s2	# $t0 = (s1 < s2)
	slt $t1,$s2,$s3	# $t2 = (s2 < s3)
	slt $t2,$s1,$s3	# $t1 = (s1 < s3)

	beq $t0,1,s1_troca_s2 # se s1 < s2, troca os valores de s1 com s2
	beq $t1,1,s2_troca_s3 # se s2 < s3, troca os valores de s2 com s3
	beq $t2,1,s1_troca_s3 # se s1 < s3, troca os valores de s1 com s3
	
	# se nenhuma das condicoes foram atendidas, os blocos ja estao ordenados
		
saida:
	# imprime as strings e os numeros em ordem descrescente s1 > s2 > s3
	la $a0,ordenacao
	jal imprime_string
	
	add $a0,$zero,$s1
	jal imprime_int
	la $a0,espaco
	jal imprime_string
	
	add $a0,$zero,$s2
	jal imprime_int
	la $a0,espaco
	jal imprime_string
	
	add $a0,$zero,$s3
	jal imprime_int
	la $a0,espaco
	jal imprime_string
	
	# finaliza o programa
	addi $v0,$zero,10
	syscall
	
s1_troca_s2:	# troca os valores entre s1 e s2 para ficar s1 > s2
	add $t9,$zero,$s1
	add $s1,$zero,$s2
	add $s2,$zero,$t9
	j condicional			
	
s2_troca_s3:	# troca os valores entre s1 e s2 para ficar s2 > s3
	add $t9,$zero,$s2
	add $s2,$zero,$s3
	add $s3,$zero,$t9
	j condicional	

s1_troca_s3:	# troca os valores entre s1 e s3 para ficar s1 > s3
	add $t9,$zero,$s1
	add $s1,$zero,$s3
	add $s3,$zero,$t9
	j condicional
	
imprime_string:	# imprime a string em $a0
	addi $v0,$zero,4
	syscall
	jr $ra
	
imprime_int:	# imprime o inteiro em $a0
	addi $v0,$zero,1
	syscall
	jr $ra
	
le_int:		# lê um inteiro e o armazena em $v0
	addi $v0,$zero,5
	syscall
	jr $ra	