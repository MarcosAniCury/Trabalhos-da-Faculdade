#include <stdio.h>
#include <stdlib.h>

void sum_openMP(double *a, double *s, int width)
{
#pragma omp parallel
    {
        int tid = omp_get_thread_num();
        int num_threads = omp_get_num_threads();

        int chunk_size = (width + num_threads - 1) / num_threads;
        int start = tid * chunk_size;
        int end = (tid + 1) * chunk_size;
        end = (end < width) ? end : width;

        double local_sum = 0.0;

        for (int i = start; i < end; ++i)
        {
            local_sum += a[i];
        }

#pragma omp critical
        s[tid] = local_sum;
    }

    for (int i = 1; i < num_threads; ++i)
    {
        s[0] += s[i];
    }
}

int main()
{
    int width = 40000000;
    int size = width * sizeof(double);

    double *a = (double *)malloc(size);
    double *s = (double *)malloc(size);

    for (int i = 0; i < width; i++)
        a[i] = i;

    sum_openMP(a, s, width);

    printf("\nSum = %f\n", s[0]);

    free(a);
    free(s);

    return 0;
}
