/*
i) compilar o código sum_cuda.cu e medir o seu tempo de execução com a função "time".

Tempo de execução:
real    0m0,490s
user    0m0,274s
sys     0m0,211s

Informações da máquina de teste:
Modelo do Hardware: Dell Inc. Inspiron 7472
Memória: 16,0GiB
CPU: Intel® Core™ i7-8550U × 8
GPU: NVIDIA GeForce MX150 / Intel® UHD Graphics 620 (KBL GT2)
Capacidade de Disco: 2,0TB
Nome do Sistema Operacional: Fedora Linux 38 (Workstation Edition)

*/

/*
ii) executar o código com o comando nvprof e anotar o tempo gasto com as seguintes funções: [CUDA memcpy HtoD] e sum_cuda(double*, double*, int).

O tempo gasto com a função '[CUDA memcpy HtoD]' é de 122.11ms.

O tempo gasto com a função 'sum_cuda(double*, double*, int)' é de 27.797ms

Saida do nvprof:
"
==11778== NVPROF is profiling process 11778, command: ./sum_cuda.out
==11778== Profiling application: ./sum_cuda.out
==11778== Profiling result:
            Type  Time(%)      Time     Calls       Avg       Min       Max  Name
 GPU activities:   81.41%  122.11ms         1  122.11ms  122.11ms  122.11ms  [CUDA memcpy HtoD]
                   18.53%  27.797ms         1  27.797ms  27.797ms  27.797ms  sum_cuda(double*, double*, int)
                    0.06%  95.519us         1  95.519us  95.519us  95.519us  [CUDA memcpy DtoH]
      API calls:   57.45%  150.14ms         2  75.072ms  28.166ms  121.98ms  cudaMemcpy
                   32.13%  83.985ms         2  41.992ms  1.1066ms  82.878ms  cudaMalloc
                    8.94%  23.362ms         1  23.362ms  23.362ms  23.362ms  cudaLaunchKernel
                    1.41%  3.6917ms         2  1.8459ms  465.26us  3.2265ms  cudaFree
                    0.06%  160.10us       114  1.4040us     119ns  64.190us  cuDeviceGetAttribute
                    0.01%  16.495us         1  16.495us  16.495us  16.495us  cuDeviceGetName
                    0.00%  4.6540us         1  4.6540us  4.6540us  4.6540us  cuDeviceGetPCIBusId
                    0.00%  1.3710us         3     457ns     137ns  1.0250us  cuDeviceGetCount
                    0.00%     636ns         2     318ns     127ns     509ns  cuDeviceGet
                    0.00%     474ns         1     474ns     474ns     474ns  cuDeviceTotalMem
                    0.00%     328ns         1     328ns     328ns     328ns  cuModuleGetLoadingMode
                    0.00%     203ns         1     203ns     203ns     203ns  cuDeviceGetUuid
"

Informações da máquina de teste:
Modelo do Hardware: Dell Inc. Inspiron 7472
Memória: 16,0GiB
CPU: Intel® Core™ i7-8550U × 8
GPU: NVIDIA GeForce MX150 / Intel® UHD Graphics 620 (KBL GT2)
Capacidade de Disco: 2,0TB
Nome do Sistema Operacional: Fedora Linux 38 (Workstation Edition)
*/