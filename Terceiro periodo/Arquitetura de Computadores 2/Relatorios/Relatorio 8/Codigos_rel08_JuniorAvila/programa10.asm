.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16 
	
	lw $s0, 0($t0)
	lw $s1, 4($t0)
	
	addi $t1, $0, 127
	mult $s0, $t1

	mflo $s0
	
	addi $t1, $zero, 65
	mult $s1, $t1
	mflo $s1
	
	sub $s2, $s0, $s1
	addi $s2, $s2, 1
	sw $s2, 8($t0)
	
	
.data
x: .word 5
z: .word 7
y: .word 0