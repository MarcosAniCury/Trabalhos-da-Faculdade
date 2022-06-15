.text
.globl main
main:
	addi $s0, $zero, 0x186A
	sll $s0, $s0, 8
	addi $s1, $zero, 0x1388
	sll $s1, $s1, 4
	addi $s2, $zero, 0x61A8
	sll $s2, $s2, 4
	
	div $s0, $s2
	mfhi $t1
	mflo $t2
	add $s3, $t1, $t2

	mult $s3, $s1
	mfhi $t1
	mflo $t2
	add $t4, $t1, $t2
	add $t3, $t3, $t4
	
.data
