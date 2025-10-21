.data
msg1: .asciiz "Digite o primeiro numero: "
msg2: .asciiz "Digite o segundo numero: "
msg3: .asciiz "A soma dos dois numeros eh: "

.text
# printar msg1
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg1 		# $a0 = &msg1;
syscall			# imprime a string "Digite o primeiro numero: "

# ler o 1o inteiro
addi $v0,$zero,5	# $v0 = 5; ler inteiro
syscall			# lê o primeiro inteiro e o armazena em $v0
add $t0,$zero,$v0	# $t0 = $v0; armazena o primeiro inteiro lido em $t0

# printar msg2
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg2 		# $a0 = &msg2; 
syscall			# imprime a string "Digite o segundo numero: "

# ler o 2o inteiro
addi $v0,$zero,5	# $v0 = 5; ler inteiro
syscall			# lê o segundo inteiro e o armazena em $v0
add $t1,$zero,$v0	# $t1 = $v0; armazena o segundo inteiro lido em $t1

# printar msg3
addi $v0,$zero,4	# $v0 = 4; imprimir string
la $a0,msg3 		# $a0 = &msg3 
syscall			# imprime a string "A soma dos dois numeros eh: "

# printar a soma dos dois inteiros lidos
addi $v0,$zero,1	# $v0 = 1; imprimir inteiro
add $a0,$t0,$t1		# $a0 = $t0 + $t1; soma os dois inteiros lidos e os armazena em $a0
syscall			# imprime o inteiro armazenado em $a0 (soma de $t0 + $t1)

# sai do programa
addi $v0,$zero,10	# $v0 = 10; sair do programa (boas praticas de assembly)
syscall			# sai do programa