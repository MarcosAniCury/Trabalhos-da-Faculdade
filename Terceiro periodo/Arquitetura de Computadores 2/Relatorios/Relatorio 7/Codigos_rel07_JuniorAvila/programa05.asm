.text
.globl main
main:
	addi $s0, $0, 0x186
	sll $s0, $s0, 8
	ori $s0, $s0, 0xA0
	addi $s1, $0, 0x30D
	sll $s1, $s1, 8
	ori $s1, $s1, 0x40
	add $s2, $s0, $s1
.data