.text
.globl main
main:
	addi $t0, $0, 0x1001
	sll $t0, $t0, 16
	lw $s0, 0($t0)
	lw $s1, 4($t0)
	lw $s2, 8($t0)
	lw $s3, 12($t0)
	lw $s4, 16($t0)
	add $t1, $s0, $s1
	add $t2, $s2, $s3
	add $s4, $s4, $t1
	add $s4, $s4, $t2
	sw $s4, 16($t0)
.data
x1: .word 15 # 0x10010000
x2: .word 25 # 0x10010004
x3: .word 13 # 0x10010008
x4: .word 17 # 0x10010012
soma: .word -1 # 0x10010016
