.text
.globl main
main:
	addi $s0, $0, 3
	addi $s1, $0, 4
	sll $t0, $s0, 4
	sub $t0, $t0, $s0
	sll $t1, $s1, 6
	add $t1, $t1, $s1
	add $t1, $t1, $s1
	add $t1, $t1, $s1
	add $s2, $t0, $t1
	sll $s2, $s2, 2
.data
