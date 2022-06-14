.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	lw $s0, 0($t0)
	
	slt $t1, $s0, $0
	bne $t1, $zero, Less
	slt $t1, $s0, $0
	beq $t1, $zero, Gteq
	
	
Less:
	addi $t2, $0, -1
	mult $s0, $t2
	mflo $s0
	sw $s0, 0($t0)

Gteq: 
	sw $s0, 0($t0)
			
.data
A: .word -11
