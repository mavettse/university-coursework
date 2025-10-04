.data	
input: .asciiz "Digite um numero positivo: "
output: .asciiz "Somatorio: "

.text
# imprime as strings e lê os números digitados pelo usuário
la $a0,input
addi $v0,$zero,4
syscall
addi $v0,$zero,5
syscall	
add $s0,$zero,$v0
	
# inicializa o contador $t0 = 1 e a soma $t1 = 0
add $t0,$zero,$zero
add $t1,$zero,$zero

# loop para fazer o somatorio
somatorio:	
	# se a contadora for menor que o numero, pula pra saida
	slt $t2,$t0,$s0
	beq $t2,$zero,saida
	# incrementa a soma
	add $t1,$t1,$t0
	addi $t0,$t0,1
	j somatorio

# imprime a string final, o inteiro e fecha o programa
saida:	
	la $a0,output
	addi $v0,$zero,4
	syscall
	add $a0,$zero,$t1
	addi $v0,$zero,1
	syscall
	addi $v0,$zero,10
	syscall
	