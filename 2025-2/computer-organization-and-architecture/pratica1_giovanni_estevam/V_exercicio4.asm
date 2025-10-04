.data 
input_msg: .asciiz "Informe um numero: "
default_msg: .asciiz "Opcao invalida\n"
output_msg: .asciiz "O resultado é: "

.text
define:
	# definindo as constantes g, h, i, j
	addi $s0,$zero,16	# $s0 = g
	addi $s1,$zero,12	# $s1 = h
	addi $s2,$zero,8 	# $s2 = i
	addi $s3,$zero,4 	# $s3 = j

input: 
	# imprime mensagem de input
	la $a0,input_msg
	addi $v0,$zero,4
	syscall

	# le o inteiro digitado pelo usuario e o armazena em $s4
	addi $v0,$zero,5
	syscall
	add $s4,$v0,$zero

switch: 
	beq $s4,0,case0
	beq $s4,1,case1
	beq $s4,2,case2
	beq $s4,3,case3
	
	# imprime o default se nenhum dos casos forem atendidos e volta para o label input
	la $a0,default_msg
	addi $v0,$zero,4
	syscall
	j input
	
end:
	# finaliza o programa
	addi $v0,$zero,10
	syscall
	
output:
	# imprime o resultado da operacao na tela
	la $a0,output_msg
	addi $v0,$zero,4
	syscall
	add $a0,$zero,$s4
	addi $v0,$zero,1
	syscall
	j end
	
case0:
	# f ($s4) = g ($s0) + (i ($s2) * j ($s3))
	j multiplica
	
case1:
	# f ($s4) = i ($s2) + g ($s0) + h ($s1)
	add $s4,$s2,$s0	# $s4 = $s2 + $s0 || f = i + g
	add $s4,$s4,$s1	# $s4 = $s4 + $s1 || f = f + h
	j output

case2:
	# f ($s4) = j ($s3) + (g ($s0) – h ($s1))
	sub $s4,$s0,$s1	# $s4 = $s0 - $s1 || f = g - h
	add $s4,$s4,$s3	# $s4 = $s4 + $s3 || f = f + j
	j output

case3:
	# f ($s4) = (i ($s2) + g ($s0)) / (j ($s3) + h ($s1))
	add $t0,$s2,$s0	# $t0 = $s2 + $s0 || t0 = i + g (t0 será o dividendo)
	add $t1,$s3,$s1	# $t1 = $s3 + $s1 || t1 = j + h (t1 será o divisor)
	add $s4,$zero,$zero # $s4 será o quociente
	j divide

multiplica: 
	# f ($s4) = g ($s0) + (i ($s2) * j ($s3))
	add $t0,$zero,$zero # $t0 sera o contador
	add $s4,$zero,$s0 # faz s4 (que contem o resultado) ser igual a $s0 (g)
	
loopM:
	addi $t0,$t0,1 # incrementa o contador
	add $s4,$s4,$s2	# s4 = s4 + s2 (incrementa o i ($s2) j ($s3) vezes no resultado ($s4))
	slt $t1,$t0,$s3 # se t0 < s3 (o contador for menor que a quantidade de vezes j, faz a soma de novo)
	bne $t1,$zero,loopM # se a condicao acima for atendida, itera novamente no loop
	j output # se a condicao nao for atendida, imprime o output
	
divide: 
	slt $t2,$t0,$t1 # se o dividendo for menor que o divisor, para o loop
	bne $t2,$zero,output # se a condicao acima for atendida, imprime o output (somente o numero inteiro)
	sub $t0,$t0,$t1 # subtrai o divisor do dividendo
	addi $s4,$s4,1 # soma um no quociente
	j divide # se chegar ao fim do bloco, itera novamente no loop
