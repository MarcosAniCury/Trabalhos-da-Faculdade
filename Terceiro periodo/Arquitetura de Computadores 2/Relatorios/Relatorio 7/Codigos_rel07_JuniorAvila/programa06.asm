.text
.globl main
main:
	addi $s0, $0, 0x7FFF
	sll $s0, $s0, 16
	ori $s0, $s0, 0xFFFF
	addi $s1, $0, 0x493E
	sll $s1, $s1, 4
	add $s1, $s1, $s1
	add $s1, $s1, $s1
	sub $s2, $s0, $s1
.data
