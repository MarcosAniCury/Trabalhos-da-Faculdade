.text
.globl main
main:
addi $t3 ,$0, 100
addi $s0, $0, 0 
addi $s1, $0, 200 
addi $s2, $0, 0x1001
sll $s2, $s2, 16
do:
sub $t0, $s1, $s0 
sll $t1, $s0, 2 
add $t2, $t1, $s2 
sw $t0, 0($t2) 
addi $s0, $s0, 1 
bne $s0, $t3, do
.data