.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	lw $s0, 0($t0)
	 
	slt $t1, $zero, $s0
	bne $t1, $zero, maior
	slt $t1, $zero, $s0
	beq $t1, $zero, menor
	
	
maior:
	mult $s0, $s0
	mflo $t2
	mult $t2, $s0 
	mflo $t2
	addi $t2, $t2, 1
	sw $t2, 4($t0)
	j fim


menor:
	mult $s0, $s0
	mflo $t2
	mult $t2, $s0
	mflo $t2
	mult $t2, $s0
	mflo $t2
	addi $t2, $t2, -1
	sw $t2, 4($t0)
	j fim


fim:

.data
x: .word -2
y: .word -1
