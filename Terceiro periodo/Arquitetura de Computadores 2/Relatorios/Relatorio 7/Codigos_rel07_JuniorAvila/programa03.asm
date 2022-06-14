.text
.globl main

main:
	addi $s0, $0, 3
	addi $s1, $0, 4
	add $t0, $s0, $s0
	add $t0, $t0, $t0
	add $t0, $t0, $t0
	add $t0, $t0, $t0
	sub $t0, $t0, $s0
	add $t1, $s1, $s1
	add $t1, $t1, $t1
	add $t1, $t1, $t1
	add $t1, $t1, $t1
	add $t1, $t1, $t1
	add $t1, $t1, $t1
	add $t1, $t1, $s1
	add $t1, $t1, $s1
	add $t1, $t1, $s1
	add $s2, $t0, $t1
	add $s2, $s2, $s2
	add $s2, $s2, $s2
.data