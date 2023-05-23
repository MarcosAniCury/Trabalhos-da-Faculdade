#include "generateIO.h"
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define PI 3.141592
#define CPU_N 5
int loop = 0;

/************************************************************************/
unsigned char ReadElement(FILE *p) {
  unsigned char element;
  if (1 != fread(&element, 1, 1, p)) {
    printf("Corrupt data file.\n");
    exit(-1);
  } else
    return (element);
}
/************************************************************************/
void DetSinCos(unsigned char element, float *sin_element, float *cos_element) {
  *sin_element = sin(2.0 * PI * element / 360.0);
  *cos_element = cos(2.0 * PI * element / 360.0);
}
/************************************************************************/
void DetOutput(unsigned char element, float C, float *out_even,
               float *out_odd) {
  float sin_element, cos_element;
  DetSinCos(element, &sin_element, &cos_element);
  *out_even = 2.0 * sin_element + exp(cos_element);
  *out_odd = exp(sin_element) * C;
}
/************************************************************************/

// Functions create by me
char *GenerateFileToRead(int n, int m) {
  // Generate OutputArquive
  char *arquive = generateIO(n, m);
  return arquive;
}

double mediaCpuTime(double cpuTimeArray[]) {
  double media = cpuTimeArray[0];
  for (int i = 1; i < CPU_N; i++) {
    media += cpuTimeArray[i];
  }
  return media / CPU_N;
}

void GenerateResultFile(double timeInSeconds, int nMatriz) {
  FILE *fp;
  char *filenameResult = "ResultValues.txt";

  if (loop == 0) {
    fp = fopen(filenameResult, "w");
    fprintf(fp, "Time(s);N\n");
  } else {
    fp = fopen(filenameResult, "a");
  }
  if (fp == NULL) {
    printf("Error: failed to create file\n");
    return;
  }

  fprintf(fp, "%f;%d\n", timeInSeconds, nMatriz);
  fclose(fp);
  loop++;
}

int main(int argc, char **argv) {
  char option;
  int loops = 1;
  int rows, cols;
  double cpuTime[CPU_N];

  printf("Deseja em modo automático?(s,n)");
  scanf("%c", &option);
  if (option == 's') {
    printf("\nDigite a quantidade de loops:");
    scanf("%i", &loops);
  }
  for (int i = 1; i <= loops; i++) {
    for (int j = 0; j < CPU_N; j++) {
      rows = i / 2;
      if (i % 2 != 0) {
        rows++;
      }
      cols = i / 2;
      printf("rows %d, cols %d\n", rows, cols);
      run(rows, cols, &cpuTime[j]);
    }
    GenerateResultFile(mediaCpuTime(cpuTime), cols + rows);
  }
}

//*************************************************************************

int run(int rows, int cols, double *cpuTimeUsed) {
  FILE *data_file;
  int i, j;
  unsigned char element, *M;
  float out_even, out_odd, *Q, C[256];
  clock_t start_time, end_time;

  // Generate file
  char *filename = GenerateFileToRead(rows, cols);

  start_time = clock();

  if (NULL == (data_file = fopen(filename, "rb"))) {
    printf("File not found.\n");
    exit(-1);
  }

  if (!(M = (unsigned char *)malloc((long)rows * cols))) {
    printf("Not enough memory to read file.\n");
    exit(-1);
  }

  for (j = 0; j < rows; j++)
    for (i = 0; i < cols; i++)
      *(M + j * cols + i) = ReadElement(data_file);
  fclose(data_file);

  if (!(Q = (float *)malloc((long)rows * cols * sizeof(float)))) {
    printf("Not enough memory for output matrix.\n");
    exit(-1);
  }

  for (i = 0; i < 256; i++)
    C[i] = 0.0;

  for (i = 0; i < cols; i++)
    for (j = 0; j < rows; j++) {
      element = *(M + j * cols + i);
      C[element]++;
    }

  for (i = 0; i < cols; i++)
    for (j = 0; j < rows; j++) {
      element = *(M + j * cols + i);
      DetOutput(element, (C[element] > 0) ? log(C[element]) : 0.0, &out_even,
                &out_odd);
      if ((element % 2) == 0)
        *(Q + j * cols + i) = pow(out_even, 2);
      else
        *(Q + j * cols + i) = out_odd;
    }

  end_time = clock();

  *cpuTimeUsed = ((double)(end_time - start_time)) / CLOCKS_PER_SEC;

  printf("Tempo de execução: %f segundos\n", *cpuTimeUsed);

  for (i = 0; i < cols; i++)
    for (j = 0; j < rows; j++)
      printf("%f ", *(Q + j * cols + i));
}
