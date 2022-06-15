#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

using namespace std;

struct Murder
{
    char nome[10];
    bool morto = 0;
    int kills = 0;
};

typedef struct Murder Murder;

int main()
{
    Murder assasino[1000];
    int i = 0;
    do
    {
        scanf("%s",&assasino[i].nome);
        i++;
    }while(assasino[i-1].nome[0] != 'F' && assasino[i-1].nome[1] != 'I' && assasino[i-1].nome[2] != 'M');
    i--;
    int cont = 0;
    for(int j = 0;j != i; j= j+2)
    {
        assasino[j].kills++;
        for (int k = 0;k < i;k+=2)
        {
            if(strcmp(assasino[j].nome,assasino[k].nome) == 0)
                assasino[k].morto = 1;
        }
    }
    printf("HALL OF MURDERERS ");
    for (int j = 0;j < i;j=j+2)
    {
        if(assasino[j].morto == 0)
        {
            printf("%s %d ",assasino[j].nome,assasino[j].kills);
        }
    }
    return 0;
}
