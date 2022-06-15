#!/bin/bash
arq=$(cat dados20192.txt)
nom_mem=$(echo "$arq" | grep 'user004')
nom_mem=$(echo "$nom_mem" | cut -d ' ' -f 4 | grep -P '^[1-2][0-9]{3,}')
echo "$nom_mem" | wc -l

