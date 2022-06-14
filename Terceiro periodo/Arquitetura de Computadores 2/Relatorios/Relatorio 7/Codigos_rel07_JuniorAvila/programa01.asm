.text
.globl main

main:
addi $s0, $0, 2
addi $s1, $0, 3
addi $s2, $0, 4
addi $s3, $0, 5
add $t0, $s0, $s1
add $t1, $s2, $s3
sub $s4, $t0, $t1
sub $s5, $s0, $s1
add $s5, $s5, $s4
sub $s1, $s4, $s5

.data
