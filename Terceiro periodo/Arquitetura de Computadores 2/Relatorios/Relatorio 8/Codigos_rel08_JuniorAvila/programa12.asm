.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	lw $s1, 0($t0)
	
	sll $t1, $s1, 2
	add $t2, $t1, $t0
	sll $t1, $t1, 2
	add $t3, $t1, $t0
	sll $t1, $t1, 2 
	add $t4, $t1, $t0 
	lw $s0, 0($t4) 
	# sw $t1, 0($t2) 
.data
x: .word 5
