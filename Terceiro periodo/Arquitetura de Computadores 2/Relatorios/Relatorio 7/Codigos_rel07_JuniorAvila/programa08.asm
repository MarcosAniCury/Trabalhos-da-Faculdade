.text
.globl main
main:
	addi $8, $0, 0x1234
	sll $8, $8, 16
	addi $8, $8, 0x5678
	sra $9, $8, 24
	sll $10, $8, 8
	sra $10, $10, 24
	sll $11, $8, 16
	sra $11, $11, 24
	sll $12, $8, 24
	sra $12, $12, 24
.data