#!/bin/bash

declare -i num1=$1
declare -i num2=$2

arq="./numprimos_$num1-$num2.txt"
if [ $num1 -lt 2 ] || [ $num2 -gt 10000 ]; 
then
	echo "O primeiro numero $num1 , é invalido, por favor, digite um numero entre 2 e 		10.000"
exit
fi

if [ $num2 -lt 2 ] || [ $num2 -gt 10000 ]; 
then
	echo "O Segundo numero $num2 , é invalido, por favor, digite um numero entre 2 		e 		10.000"
exit
fi

for for1 in $(seq $num1 $num2 ); 
do
	declare -i cont=0
	for for2 in $(seq 1 $for1 ); 
	do
		resul=$(($for1%$for2))
		if [ $resul -eq 0 ] 
		then
			cont=$(($cont+1))
		fi
	done
	if [ $cont -eq 2 ] 
	then
		echo "O numero $for1 é primo" >> $arq
	fi
done

