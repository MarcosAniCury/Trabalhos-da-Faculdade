#include <stdio.h>
#include <stdlib.h>
#include "D:\faculdade\AED 1\Bibliotecas\funcoesmarcos.h"
//Favor verificar e corrigir local de destino da biblioteca.

/***************************************************************
 * Assinatura da fun��o:
 * Data da elabora��o:25/09/2019
 * Autor:Marcos Ani Cury
 * Objetivo:Maior valor entre dois numeros
 * Dados de entrada (argumentos):float (A,B)
 * Dado de sa�da (valor gerado pela fun��o):Void
 **************************************************************** */

void apresentacao();

int main()
{
    float A,B;
    apresentacao();
    A = valreal();
    B = valreal();
    maiorentre2f_2(A,B);
    return 0;
}

void apresentacao()
{
    printf("\n Algoritmo para calcular o maior valor entre dois valores reais.");
}
