.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	
	lw $s1, 0($t0)
	lw $s2, 4($t0)
	
	addi $s3, $zero, 1
	
	slt $t1, $s3, $s2
	bne $t1, $zero, inicio
	slt $t1, $s3, $s2
	beq $t1, $zero, fim
	
inicio:
	mult $s1, $s1
	mflo $s0
	addi $s3, $s3, 1
	
	slt $t1, $s3, $s2
	bne $t1, $zero, loop
	slt $t1, $s3, $s2
	beq $t1, $zero, fim

loop:
	mult $s0, $s1
	mflo $s0
	addi $s3, $s3, 1
	
	slt $t1, $s3, $s2
	bne $t1, $zero, loop
	slt $t1, $s3, $s2
	beq $t1, $zero, fim


fim:
	sw $s0, 8($t0)

				
.data
x: .word 5 # 0x10010000
y: .word 3 # 0x10010004