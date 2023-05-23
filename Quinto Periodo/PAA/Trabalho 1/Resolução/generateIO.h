#include <stdio.h>
#include <stdlib.h>

extern char *generateIO(int n, int m) {
  FILE *fp;
  char *filename = "RandomMatriz.txt";

  fp = fopen(filename, "w");
  if (fp == NULL) {
    printf("Error: failed to create file\n");
    return "Error";
  }

  int numberRandom = 0;

  printf("\nMatriz gerada é:\n");

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      numberRandom = rand() % 255;
      printf("%d|", numberRandom);
      fprintf(fp, "%d|", numberRandom);
    }
    printf("\n");
    fprintf(fp, "\n");
  }

  printf("\n\n\n");

  fclose(fp);
  return filename;
}