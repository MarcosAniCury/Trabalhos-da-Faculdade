#!/bin/bash
arq=$(cat dados20192.txt)
mem_nome=$(echo "$arq" | cut -d ' ' -f 4,8)
mem_nome=$(echo "$mem_nome" | sort -t 1 -g)
echo "$mem_nome" | tail -n 1 | cut -d ' ' -f 2 

