.data	
msg: .asciiz "Selecione uma opcao:\n\n1. Soma dois numeros\n2. Subtrai dois numeros\n3. Multiplica dois numeros\n4. Exponencial de um numero\n\n"

num: .asciiz "Digite o numero: "
num1: .asciiz "Digite o 1o numero: "
num2: .asciiz "Digite o 2o numero: "
res: .asciiz "Resultado = "

.text
input:
	# imprime as opcoes e armazena a opcao do usuario em $t0
	la $a0,msg
	jal imprime_string
	jal le_int
	add $t0,$zero,$v0
	
	# verifica se foi inserido valor invalido
	slti $t1,$t0,1	# se t0 < 1, finaliza do programa
	bne $t1,$zero,finaliza
	slti $t1,$t0,5	# se t0 >= 5, finaliza do progrma
	beq $t1,$zero,finaliza
	
	# imprime mensagem e armazena o primeiro e o segundo número em s0 e s1, respectivamente
	la $a0,num1
	jal imprime_string
	jal le_int
	add $s0,$zero,$v0
	la $a0,num2
	jal imprime_string
	jal le_int
	add $s1,$zero,$v0
	
	# vai para os respectivos blocos das opcoes disponiveis
	beq $t0,1,soma
	beq $t0,2,subt
	# inicializa o resultado e a contadora t2 com 0
	add $s2,$zero,$zero
	add $t1,$zero,$zero
	beq $t0,3,multi
	# inicializa o resultado s2 com 1 
	addi $s2,$zero,1
	beq $t0,4,exp 

saida:	# imprime o resultado (que sermpre estará armazenado em s2) e finaliza o programa
	la $a0,res
	jal imprime_string
	add $a0,$zero,$s2
	jal imprime_int
	
finaliza:
	addi $v0,$zero,10
	syscall
	
soma:	# soma s0 com s1 e armazena em s2
	add $s2,$s0,$s1
	j saida
	
subt:	# subtrai s0 de s1 e armazena em s2
	sub $s2,$s0,$s1
	j saida

multi:	
	slt $t2,$t1,$s1	# se a contadora for maior ou igual que o segundo numero, sai do loop
	beq $t2,$zero,saida
	add $s2,$s2,$s0	# faz a multiplicacao
	addi $t1,$t1,1	# incrementa a contadora
	j multi		# continua no loop

exp:	# calcula s0^s1 e armazena em s2
	slt $t3,$t2,$s1		# se a contadora for maior ou igual ao expoente, termina a conta
	beq $t3,$zero,saida
	add $t5,$zero,$zero 	# zera a contadora da multiplicacao
	add $t1,$zero,$s0	# inicializa t1 com a base s0

exp_int:
	beq $t1,$zero,exp_fim	# se a base (t1) for 0, para o loop interno
	add $t5,$t5,$s2		# faz a multiplicacao
	addi $t1,$t1,-1		# decrementa a contadora
	j exp_int
	
exp_fim:
	add $s2,$zero,$t5	# salva o resultado da multiplicacao interna em s2 novamente
	addi $t2,$t2,1		# incrementa o contador do loop externo
	j exp
	

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