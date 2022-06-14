.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	
	lw $s0, 0($t0)
	lw $s1, 4($t0)
	
	mult $s0, $s1
	mfhi $t1
	mflo $t2
	
	add $s2, $t1, $t2
	
	sw $s2 8($t0)
	

.data
x: .word 3
y: .word 5
k: .word -1
