.text
.globl main
main:
	addi $s0, $0, 0x1001
	sll $s0, $s0, 16
	
	add $s1, $0, $0
	addi $t0, $0, 100
	
	add $s2, $zero, $zero
	
	slt $t1, $s1, $t0
	bne $t1, $0, Loop
Loop:
	addi $t2, $zero, 2
	mult $s1, $t2
	mflo $s4
	addi $t3, $s4, 1
	add $s2, $s2, $t3
	
	sll $s3, $s1, 2
	add $s3, $s3, $s0
	sw $t3, 0($s3)
	
	addi $s1, $s1, 1
	slt $t1, $s1, $t0
	bne $t1, $zero, Loop
	slt $t1, $s1, $t0
	beq $s1, $t0, End
	
End:
	sll $s3, $s1, 2
	add $s3, $s3, $s0
	sw $s2, 0($s3)
.data
