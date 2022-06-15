.text
.globl main

main:
addi $s0, $0, 1
add $s1, $s0, $s0
add $s1, $s1, $s1
add $s1, $s1, $s0
addi $s1, $s1, 15

.data