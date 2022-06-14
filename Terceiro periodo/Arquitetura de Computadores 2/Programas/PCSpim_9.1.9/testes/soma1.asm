## Programa para somar 2 mais 3
.text
.globl main
main:
addi $8,$0,0x2 # coloca o comp. de dois do dois no reg. 8
addi $9,$0,0x3 # coloca o comp. de dois do três no reg. 9
add $10,$8,$9 # soma regs. 8 e 9, coloca resultado em 10
## fi