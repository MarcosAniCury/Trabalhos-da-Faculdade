#include <iostream>
#include <stdlib.h>
#include <stdio.h>

int main()
{
    int n;
    int piano[n];
    int q;
    scanf("%i", n);
    scanf("%i", q);
    int acorde1[q];
    int acorde2[q];
    for (int i = 0;i < q;i++)
    {
        scanf("%d", acorde1[i]);
        scanf("%d", acorde2[i]);
    }
    for (int i = 0;i < n;i++)
        piano[i] = 1;
    for (int i = 0;i < q;i++)
    {
        int cont[9];
        int maior;
        for (int j = acorde1[i]; j <= acorde2[i]; j++)
        {
            cont[piano[j]]++;
        }
        maior = cont[0];
        for (int j = 0;j < 9;j++)
        {
            if (maior <= cont[i])
                maior = cont[i];
        }
        for (int j = acorde1[i]; j < acorde2[i];j++)
        {
            piano[j] = (piano[j] + maior) % 9;
        }
    }
    for (int i = 0; i < n;i++)
        printf("%d", piano[i]);
}
