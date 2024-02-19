cmake_minimum_required(VERSION 3.26)
project(Tarefa_23___Tarefa_24_-_Somatorio_em_CUDA)
set(CMAKE_CXX_STANDARD 14)

##### Sequencial #####
add_executable(Sequencial sum_sequencial.c)

##### Paralela Multicore #####
add_executable(Paralela_Multicore sum_paralelo_multicore_gpu.c)
target_compile_options(Paralela_Multicore PRIVATE -fopenmp)

##### Paralela GPU #####
add_executable(Paralela_GPU sum_paralelo_gpu.c)
target_compile_options(Paralela_GPU PRIVATE -fopenmp)

##### Resposta #####
add_executable(Resposta resposta.c)
target_compile_options(Resposta PRIVATE -fopenmp)

##### NVIDIA CUDA #####
# Find CUDA package
find_package(CUDA REQUIRED)

# Set the CUDA source files
set(CUDA_SOURCE_FILES sum_cuda.cu)

# Set the -allow-unsupported-compiler flag
set(CUDA_NVCC_FLAGS ${CUDA_NVCC_FLAGS} "-allow-unsupported-compiler")

cuda_add_executable(NVIDIA_CUDA sum_cuda.cu)