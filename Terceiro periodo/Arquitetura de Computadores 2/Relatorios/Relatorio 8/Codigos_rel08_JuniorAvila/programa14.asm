.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	lw $s0, 0($t0)
	
	addi $t1, $zero, 30 # t1 = 30 limInf
	addi $t2, $zero, 50 # t2 = 50 limSup
	
	slt $t3, $s0, $t1
	bne $t3, $zero, Invalido
	slt $t3, $s0, $t1 # atribui o resultado da comparação em t3
	beq $t3, $zero, Possivel
	
	
	
Invalido:	
	addi $s1, $zero, 0
	sw $s1, 4($t0)
	beq $s1, $s1, End

Possivel:
	
	slt $t3, $t2, $s0
	bne $t3, $zero, Invalido
	slt $t3, $s0, $t1
	beq $t3, $zero, Valido

Valido: 
	add $s1, $zero, 1
	sw $s1, 4($t0)
	beq $s1, $s1, End
	
End:

.data
temp: .word 50
flag: .word -777
