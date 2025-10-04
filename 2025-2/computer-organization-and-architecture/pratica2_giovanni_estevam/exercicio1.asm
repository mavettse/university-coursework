# Giovanni Estevam Dos Santos

.data
input_msg1: .asciiz "Digite o primeiro numero: "
input_msg2: .asciiz "Digite o segundo numero: "

.text
# imprime as mensagens de input e armazena os numeros digitados pelo usuario em $s0 e $s1
input:
	# le e armazena o primeiro numero em $s0
	la $a0,input_msg1
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $s0,$zero,$v0
	# le e armazena o segundo numero em $s1
	la $a0,input_msg2
	addi $v0,$zero,4
	syscall
	addi $v0,$zero,5
	syscall
	add $s1,$zero,$v0

# armazena o maior numero em $t0 e o menor em $t1
condicao_maior: 
	slt $t3,$s0,$s1 # verifica se o primeiro numero eh menor que o segundo
	beq $t3,1,s1_maior # se o 2o numero for maior que o 1o, vai para s1_maior
	j s0_maior # se o 1o numero for maior que o 2o, vai para s0_maior
	
# subtrai o maior numero pelo menor e o armazena em $s3
subtracao:
	sub $s3,$t0,$t1

# verifica se o 1o numero digitado ($s0) eh maior que a subtracao do maior pelo menor ($s3)	
condicao_final:
	slt $a0,$s0,$s3 # se a subtracao do maior pelo menor for menor que o 1o
	
# imprime 1 ou 0 na saida
output:
	addi $v0,$zero,1
	syscall
	
# finaliza o programa
end:
	addi $v0,$zero,10
	syscall
	
# bloco para se $s0 for maior que $s1
s0_maior:
	add $t0,$zero,$s0 # armazena o maior numero $s0 em $t0
	add $t1,$zero,$s1 # armazena o menor numero $s1 em $t1
	j subtracao

# bloco para se $s1 for maior que $s0
s1_maior:
	add $t0,$zero,$s1 # armazena o maior numero $s1 em $t0
	add $t1,$zero,$s0 # armazena o menor numero $s0 em $t1
	j subtracao
	
	