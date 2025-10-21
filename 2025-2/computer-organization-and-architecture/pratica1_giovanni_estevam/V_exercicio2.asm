# Giovanni Estevam Dos Santos

.data
input: .asciiz "Digite o numero de termos: "
espaco: .asciiz " "

.text
# imprime o input na tela
la $a0,input
addi $v0,$zero,4
syscall

# lê o inteiro e o armazena em $s0 
addi $v0,$zero,5
syscall
add $s0,$zero,$v0

# se a entrada for menor que 1, pula para a saida
slti $t0,$s0,1		
bne $t0,$zero,exit

# inicializa uma variavel auxiliar ($t1) com 1 e a variavel com a sequencia (&t1) com 1
addi $t0,$zero,1
addi $t1,$zero,1

# faz o loop
loop: 
	# imprime o numero e o espaco
	addi $v0,$zero,1
	add $a0,$zero,$t1
	syscall			
	addi $v0,$zero,4
	la $a0,espaco
	syscall
		
	# se a sequencia ($t1) for 1, vai para o label maisum; se não, procede no loop
	beq $t1,$t0,maisum
	
	# soma 2 na sequência (%t1) e subtrai 1 do contador (%s0, que também é a variável que armazenou o output)
	addi $t1,$t1,2	
	sub $s0,$s0,$t0
	
	# se o contador ($s0) for maior que 1 ($t0), reinicia o loop
	slt $t3,$s0,$t0		
	beq $t3,$zero,loop

# finaliza o programa
exit:
	addi $v0,$zero,10
	syscall
	
# soma 1 no primeiro valor da sequencia ($t1)
maisum: 
	addi $t1,$t1,1
	sub $s0,$s0,$t0
	beq $s0,$zero,exit	# se o contador ($s0) for zero, vai finaliza o programa; se não, volta para o loop
	j loop
