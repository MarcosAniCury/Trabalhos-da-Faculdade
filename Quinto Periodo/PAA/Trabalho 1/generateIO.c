#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *fp;
    char filename[] = "GenerateIOOutput.txt";

    fp = fopen(filename, "w");
    if (fp == NULL)
    {
        printf("Error: failed to create file\n");
        return 1;
    }

    int n = 0;
    int m = 0;

    printf("Digite o numero de linhas da matriz:");
    scanf("%d", &n);

    printf("Digite o numero de colunas da matriz:");
    scanf("%d", &m);

    srand(time(NULL));

    int numberRandom = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            numberRandom = rand() % 255;
            printf("%d\n", numberRandom);
            fprintf(fp, "%d|", numberRandom);
        }
        fprintf(fp, "\n");
    }

    fclose(fp);
    return 0;
}