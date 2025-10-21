.data
vetor: .word 0:19				# declaracao de um vetor com 20 posicoes

msg1: .asciiz "Informe um numero: "		# declaracao da mensagem inicial 
msg2: .asciiz "Novos valores do vetor: "	# declaracao da mensagem final
espaco: .asciiz " "				# declaracao da mensagem que contem um espaco

.text
# inicializa $t0 com o endereco do inicio do vetor e $t1 com 0 para ser o contador
la $t0,vetor
add $t1,$zero,$zero

loopleitura:
	# imprime a mensagem de entrada
	addi $v0,$zero,4
	la $a0,msg1
	syscall
	
	# le o numero digitado pelo usuario e o armazena no vetor
	addi $v0,$zero,5
	syscall
	sw $v0,($t0)
	
	# incrementa 4 na posicao de memoria ($t0) e 1 no contador ($t1)
	addi $t0,$t0,4
	addi $t1,$t1,1
	
	# se o contador ($t1) for menor que 20, continua no loop;
	slti $t2,$t1,20
	bne $t2,$zero,loopleitura
	
# inicializa $t0 com o endereco do inicio do vetor, $t1 com o valor da ultima posicao do vetor, $t2 com 0 para ser o contador 
# e $t3 com 0 para ser a soma
la $t0,vetor
lw $t1,76($t0)
add $t2,$zero,$zero
add $t3,$zero,$zero
	
loopsoma:
	# incrementa a soma ($t3) com o valor da ultima posicao do vetor ($t1) e o insere na posicao atual do vetor ($t0)
	add $t3,$t3,$t1
	sw $t3,($t0)

	# incrementa 4 na posicao de memoria ($t0) e 1 no contador ($t2)
	addi $t0,$t0,4
	addi $t2,$t2,1
	
	# se o contador ($t2) for menor que 20, continua no loop;
	slti $t4,$t2,20
	bne $t4,$zero,loopsoma
	
# inicializa $t0 com o endereco do inicio do vetor, $t1 com 0 para ser o contador
la $t0,vetor
add $t1,$zero,$zero
	
# imprime a mensagem de saida
addi $v0,$zero,4
la $a0,msg2
syscall

loopsaida: 
	# le o valor dentro do vetor ($t0) e o armazena no auxiliar ($t4)
	lw $t4,($t0)
	
	# imprime o valor atual do vetor ($t4)
	add $a0,$zero,$t4
	addi $v0,$zero,1
	syscall
	
	# imprime o espaco
	la $a0,espaco
	addi $v0,$zero,4
	syscall
	
	# incrementa 4 na posicao de memoria ($t0) e 1 no contador ($t1)
	addi $t0,$t0,4
	addi $t1,$t1,1
	
	# se o contador ($t1) for menor que 20, continua no loop;
	slti $t2,$t1,20
	bne $t2,$zero,loopsaida
	
saida: 
	# finaliza a execucao do programa
	addi $v0,$zero,10
	syscall