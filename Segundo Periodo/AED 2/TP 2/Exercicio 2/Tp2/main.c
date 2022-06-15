#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define true 1
#define false 0

struct Personagens
{
    char nome[100];
    int altura;
    double peso;
    char corDoCabelo[30];
    char corDaPele[30];
    char corDosOlhos[30];
    char anoNascimento[20];
    char genero[20];
    char homeworld[100];
};

typedef struct Personagens Per;

int Max = 0;
Per Personagem[50];

int troca(char trocador[])
{
    int num = 0;
    for(int i = 0; i < strlen(trocador);i++)
    {
        num = trocador[i] - 48;
        num *= 10;
    }
    return num;
}

void printador()
{
    printf(" ## %s", Personagem[Max].nome);
    printf(" ## %i", Personagem[Max].altura);
    printf(" ## %d", Personagem[Max].peso);
    printf(" ## %s", Personagem[Max].corDoCabelo);
    printf(" ## %s", Personagem[Max].corDaPele);
    printf(" ## %s", Personagem[Max].corDosOlhos);
    printf(" ## %s", Personagem[Max].anoNascimento);
    printf(" ## %s", Personagem[Max].genero);
    printf(" ## %s ## ", Personagem[Max].homeworld);
}

void leitura (char frase[])
{
    int end = 0;
    int contador = 0;
    int begi = 0;
    for(int i = 0;i < strlen(frase);i++)
    {
        if(frase[i] == '\'' && frase[i + 1] == ',')
        {
            end = i - 1;
            for(int j = i - 1;j <= 0;j--)
            {
                if(frase[j] == '\'')
                {
                    begi = j + 1;
                    printf("%d", begi);
                    j=0;
                }
            }
            if (contador == 0)
            {
                char nomee[50];
                for(;begi == end;begi++)
                {
                    int j = 0;
                    nomee[j] = frase[begi];
                    Personagem[Max].nome[j] = frase[begi];
                    j++;
                }
                printf("%s", Personagem[Max].nome);
                contador++;
            }
            if (contador == 1)
            {
                char temp[5];
                for(;begi == end;begi++)
                {
                    int j = 0;
                    temp[j] = frase[begi];
                    j++;
                }
                int tempo = troca(temp);
                Personagem[Max].altura = tempo;
                contador++;
            }
            /*
            if (contador == 2)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].peso[j] = (double)frase[begi];
                    j++;
                }
                contador++;
            }
            */
            if (contador == 3)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].corDoCabelo[j] = frase[begi];
                    j++;
                }
                contador++;
            }
            if (contador == 4)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].corDaPele[j] = frase[begi];
                    j++;
                }
                contador++;
            }
            if (contador == 5)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].corDosOlhos[j] = frase[begi];
                    j++;
                }
                contador++;
            }
            if (contador == 6)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].anoNascimento[j] = frase[begi];
                    j++;
                }
                contador++;
            }
            if (contador == 7)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].genero[j] = frase[begi];
                    j++;
                }
                contador++;
            }
            if (contador == 8)
            {
                for(;begi == end;begi++)
                {
                    int j = 0;
                    Personagem[Max].homeworld[j] = frase[begi];
                    j++;
                }
                contador++;
            }
        }
    }
    Personagem[Max].altura = 20;
    printador();
    Max++;
}

void Armazenamento(char endereco[])
{
    char armazem[1000];
    FILE *arq;
    arq = fopen(endereco, "r");
    if (arq == 0)//null
        printf("\n Erro na leitura do arquivo.");
    fscanf(arq,"%[^\n]\n",&armazem);
    fclose(arq);
    printf("%s", armazem);
    leitura(armazem);
}

bool isFim(char endereco[])
{
    bool retorno = false;
    if(endereco[0] == 'F' && endereco[1] == 'I' && endereco[2] == 'M')
        retorno = true;
    return retorno;
}

int main()
{
    bool flag = false;
    char endereco[100];
    do
    {
        //Entrada de string
        scanf("%s", &endereco);
        if(isFim(endereco))
            flag = true;
        else
        {
            Armazenamento(endereco);
        }
    }while(!flag);
    return 0;
}
