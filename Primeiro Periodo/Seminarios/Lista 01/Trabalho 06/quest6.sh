#!/bin/bash

user=$1
arq=$(cat dados20192.txt)
cod=$(echo "$arq" | grep -E "^$user")
cod=$(echo "$cod" | cut -d ' ' -f 4)
soma=0
	for for1 in $cod; 
	do
		soma=$(($soma+$for1))
	done
echo "$soma"


