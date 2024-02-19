#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

/*
 *   O código original teve um tempo de 2m 17.759s
 *   O tempo do código paralelo real 0m 37.124s
 *   O ganho foi de 3.70 vezes
 */

void mm(double *a, double *b, double *c, int width)
{
    // Não faz diferença utilizar shared já que estamos lidando com ponteiros
#pragma omp parallel for
    for (int i = 0; i < width; i++)
    {
        for (int j = 0; j < width; j++)
        {
            double sum = 0;
            for (int k = 0; k < width; k++)
            {
                double x = a[i * width + k];
                double y = b[k * width + j];
                sum += x * y;
            }
            c[i * width + j] = sum;
        }
    }
}

int main()
{
    int width = 2000;
    double *a = (double *)malloc(width * width * sizeof(double));
    double *b = (double *)malloc(width * width * sizeof(double));
    double *c = (double *)malloc(width * width * sizeof(double));

#pragma omp parallel for
    for (int i = 0; i < width; i++)
    {
        for (int j = 0; j < width; j++)
        {
            a[i * width + j] = i;
            b[i * width + j] = j;
            c[i * width + j] = 0;
        }
    }

    mm(a, b, c, width);

    // for (int i = 0; i < width; i++)
    // {
    //     for (int j = 0; j < width; j++)
    //     {
    //         printf("c[%d][%d] = %f\n", i, j, c[i * width + j]);
    //     }
    // }

    free(a);
    free(b);
    free(c);

    return 0;
}
