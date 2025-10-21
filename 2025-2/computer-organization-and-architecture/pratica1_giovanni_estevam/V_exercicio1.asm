# Giovanni Estevam Dos Santos

.data
input: .asciiz "Digite um número: "
output: .asciiz "O somatorio é: "

.text
# imprime o input na tela
la $a0,input
addi $v0,$zero,4
syscall

# lê o inteiro e o armazena em $s0 
addi $v0,$zero,5
syscall
add $s0,$zero,$v0

# inicializa $t0 = 1 e $s1 = $s0 ($s1 irá conter o resultado do somatório)
addi $t0,$zero,1
addi $s1,$zero,0

# faz o loop
loop: 
	add $s1,$s1,$s0
	sub $s0,$s0,$t0
	slti $t1,$s0,1
	beq $t1,$zero,loop
	
# imprime o output na tela
addi $v0,$zero,4
la $a0,output
syscall

# imprime o resultado do somatorio
addi $v0,$zero,1
add $a0,$zero,$s1
syscall

# finaliza o programa
addi $v0,$zero,10
syscall
	
