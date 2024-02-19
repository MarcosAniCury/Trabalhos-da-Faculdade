#!/bin/bash

function comparar_saidas() {
    if ! diff -q "$1" "$2" &> /dev/null; then
        echo "As saídas: \"$1\" \"$2\" são diferentes"
        read -r -p "Deseja visualizar a diferença entre as saídas (s/n)? " visualizar
        if [ "$visualizar" == "s" ]; then
          vimdiff "$1" "$2"
        fi
    fi
}

# Limpando
bash ./Limpar.bash

# Compilando
bash ./Compilar.bash

# Executando
tempo_nvidia_cuda=$( { time ./sum_cuda.out > saida_nvidia_cuda.txt ; } 2>&1 )
tempo_sequencial=$( { time ./sum_sequencial.out > saida_sequencial.txt ; } 2>&1 )
tempo_paralelo_multicore=$( { time ./sum_paralelo_multicore_gpu.out > saida_paralela_multicore.txt ; } 2>&1 )
tempo_paralelo_gpu=$( { time ./sum_paralelo_gpu.out > saida_paralela_gpu.txt ; } 2>&1 )

# Comparando as saídas
comparar_saidas saida_nvidia_cuda.txt saida_sequencial.txt
comparar_saidas saida_nvidia_cuda.txt saida_paralela_multicore.txt
comparar_saidas saida_nvidia_cuda.txt saida_paralela_gpu.txt

# Imprimindo os tempos
echo "Tempo Sequencial:"
echo "$tempo_sequencial"
echo

echo "Tempo Paralelo Multicore:"
echo "$tempo_paralelo_multicore"
echo

echo "Tempo Paralelo GPU:"
echo "$tempo_paralelo_gpu"
echo

echo "Tempo Nvidia Cuda:"
echo "$tempo_nvidia_cuda"
echo