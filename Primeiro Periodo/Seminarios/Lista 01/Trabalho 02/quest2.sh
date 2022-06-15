#!/bin/bash

armazem=$(cat access.log)
resp=$(echo "$armazem" | grep '/Sep/' )
resp=$(echo "$resp" | cut -d ' ' -f 4)
resp=$(echo "$resp" | cut -d ':' -f '2-3')
resp=$(echo "$resp" | grep -E '^1[2-3]:[0-5][0-9]')
echo "$resp" | wc -l

