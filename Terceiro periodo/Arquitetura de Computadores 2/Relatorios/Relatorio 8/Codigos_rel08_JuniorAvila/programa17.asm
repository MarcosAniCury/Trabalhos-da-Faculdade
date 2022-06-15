.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	
	lw $s0, 0($t0)
	addi $t1, $0, 2
	div $s0, $t1
	mfhi $t2
	mflo $t3
	beq $t2, $zero, par
	j impar
	
par:
	mult $s0, $s0
	mfhi $t1
	mflo $t2
	add $t3, $t1, $t2
	add $t4, $t1, $t2
	
	mult $t3, $t3
	mfhi $t1
	mflo $t2
	add $t3, $t1, $t2
	
	mult $t4, $s0
	mfhi $t1
	mflo $t2
	add $t5, $t1, $t2
	
	addi $t1, $0, 2 
	mult $t4, $t1
	mfhi $t1
	mflo $t2
	add $t4, $t1, $t2
	
	add $s1, $t3, $t5
	sub $s1, $s1, $t4
	j fim
	
	
impar:
	mult $s0, $s0
	mfhi $t1
	mflo $t2
	add $t3, $t1, $t2
	add $t4, $t1, $t2 
	
	mult $t3, $t3
	mfhi $t1
	mflo $t2
	add $t3, $t1, $t2  
	
	mult $t3, $s0
	mfhi $t1
	mflo $t2
	add $t3, $t1, $t2 
	
	mult $t4, $s0
	mfhi $t1
	mflo $t2
	add $t4, $t1, $t2 
	
	sub $s1, $t3, $t4
	addi $s1, $s1, 1
	j fim
	
fim:
	sw $s1, 4($t0)

.data
x: .word 1
y: .word -1
