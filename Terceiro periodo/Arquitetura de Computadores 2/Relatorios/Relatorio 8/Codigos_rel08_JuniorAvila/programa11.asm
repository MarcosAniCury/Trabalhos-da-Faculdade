.text
.globl main
main:
	addi $t0, $zero, 0x1001
	sll $t0, $t0, 16
	
	lw $s0, 0($t0)
	lw $s2, 4($t0)
	sub $s1, $s0, $s2
	addi $t1, $zero, 0x493e 
	sll $t1, $t1, 4
	add $s1, $s1, $t1
	sw $s1, 8($t0)
.data
x: .word 100000
z: .word 200000
y: .word 0
