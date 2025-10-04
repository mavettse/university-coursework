.data
vetor: .word 0:2 	# declaração de vetor de 3 posições

msg1: .asciiz "Digite o primeiro numero: "
msg2: .asciiz "Digite o segundo numero: "
msg3: .asciiz "Digite o terceiro numero: "
msg4: .asciiz "O novo valor da posicao V[2] eh: "

.text
# obter endereco do inicio do vetor
la $t0,vetor		# lê o valor de endereço do inicio do vetor

# printar msg1
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg1 		# $a0 = &msg1;
syscall			# imprime a string "Digite o primeiro numero: "

# armazenar primeiro numero na primeira posicao do vetor
addi $v0,$zero,5	# $v0 = 5; ler inteiro
syscall			# lê o primeiro inteiro e o armazena em $v0
sw $v0,0($t0)		# armazena o primeiro valor lido na primeira posicao do vetor

# printar msg2
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg2 		# $a0 = &msg2; 
syscall			# imprime a string "Digite o segundo numero: "

# armazenar segundo numero na primeira posicao do vetor
addi $v0,$zero,5	# $v0 = 5; ler inteiro
syscall			# lê o segundo inteiro e o armazena em $v0
sw $v0,4($t0)		# armazena o segundo valor lido na segunda posicao do vetor

# printar msg3
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg3 		# $a0 = &msg3;
syscall			# imprime a string "Digite o terceiro numero: "

# armazenar terceiro numero na terceira posicao do vetor
addi $v0,$zero,5	# $v0 = 5; ler inteiro
syscall			# lê o primeiro inteiro e o armazena em $v0
sw $v0,8($t0)		# armazena o primeiro valor lido na primeira posicao do vetor

# armazena os valores de V[0] e V[2]
lw $t1,0($t0)		# armazena o valor da 1a posicao do vetor em $t1
lw $t2,8($t0)		# armazena o valor da 3a posicao do vetor em $t2

# troca os valores de V[0] e V[2]
sw $t2,0($t0)		# altera o valor da 1a posicao do vetor para o valor em $t2 (que contem o valor da 3a posicao)
sw $t1,8($t0)		# altera o valor da 3a posicao do vetor para o valor em $t1 (que contem o valor da 1a posicao)

# printar msg4
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg4 		# $a0 = &msg4;
syscall			# imprime a string "O novo valor da posicao V[2] eh: "

# printar V[2]
addi $v0,$zero,1	# $v0 = 1; imprimir inteiro
lw $a0,8($t0)		# pega o valor de V[2] (ultima posicao do vetor) e o armazena em $a0
syscall			# imprime o inteiro armazenado em $a0 (soma de $t0 + $t1)

# sair do programa
addi $v0,$zero,10	# $v0 = 10; sair do programa (boas praticas de assembly)
syscall			# sai do programa