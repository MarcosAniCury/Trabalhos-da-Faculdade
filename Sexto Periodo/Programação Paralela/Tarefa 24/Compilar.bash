#!/bin/bash

# Compilando
gcc sum_sequencial.c -o sum_sequencial.out
gcc sum_paralelo_multicore_gpu.c -o sum_paralelo_multicore_gpu.out -fopenmp
gcc sum_paralelo_gpu.c -o sum_paralelo_gpu.out -fopenmp
nvcc -allow-unsupported-compiler sum_cuda.cu -o sum_cuda.out