void 2elementosfila(Fila fila1, Fila fila2)
{
    mostrar2filas(fila1.primeiro, fila1.ultimo, fila2.primeiro, fila2.ultimo);
}

void mostrar2filas(Celula fila1primeiro, Celula fila1ultimo, Celula fila2primeiro, Celula fila2ultimo)
{
    Celula i = null;
    Celula j = null;
    if (fila1ultimo == null && fila2ultimo == null)
    {
        throw new Exception("Erro fila vazia!");
    }
    if (fila1primeiro.prox != fila1ultimo.prox)
    {
        MyIO.println(fila1primeiro);
        i = fila1primeiro.prox;
    }
    if (fila2primeiro.prox != fila2ultimo.prox)
    {
        MyIO.println(fila2primeiro);
        j = fila2primeiro.prox;
    }
    if (fila1primeiro.prox != fila1ultimo.prox || fila2primeiro.prox != fila2ultimo.prox)
        mostrar2filas(i, fila1ultimo, j, fila2ultimo);
    i = j = null;
}