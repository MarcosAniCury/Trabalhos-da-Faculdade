#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main()
{
    int nut,pter,r,divx,continu,temp;
    bool ero = 0;
    do
    {
        printf("\n Algoritmo de PA");
        printf("\n Digite quantos termos a PA ira ter:");
        scanf("%d", &nut);
        printf("\n Digite o primeiro termo da PA:");
        scanf("%d", &pter);
        printf("\n Digite a razao da PA:");
        scanf("%d", &r);
        printf("\n Digite um numero para saber quais termos sao divisiveis por ele:");
        scanf("%d", &divx);
        if (nut <= 0)
        {
            ero = 1;
            printf("\n Valor invalido, digite novamente.");
        }
        temp = pter <= 0 || pter > 0;
        if (!temp)
        {
            ero = 1;
            printf("\n Valor invalido, digite novamente.");
        }
        temp = r <= 0 || r > 0;
        if (!temp)
        {
            ero = 1;
            printf("\n Valor invalido, digite novamente");
        }
        temp = divx <= 0 || divx > 0;
        if (!temp)
        {
            ero = 1;
            printf("\n Valor invalido, digite novamente");
        }
        if (!ero)
        {
            printf("\n %d", pter);
            while (nut != 1)
            {
               nut--;
               pter += r;
               printf("\n %d", pter);
               temp = pter % divx;
               if (temp == 0)
                   printf(" e divisivel por %d", divx);
            }
        }
        do
        {
            printf("\n \n Deseja continuar(para sim digite 1 para nao digite 2)?");
            scanf("%d", &continu);
            if (continu < 1 || continu > 2)
                printf("\n Valor invalido, digite novamente");
        } while (continu < 1 || continu > 2);
        if (continu == 1)
            ero = 0;
        else if (continu == 2)
            ero = 1;
    } while (!ero);
    return 0;
}
