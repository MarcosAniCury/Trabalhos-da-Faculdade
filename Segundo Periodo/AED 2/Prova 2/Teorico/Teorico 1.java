void copy (Celula topo, Celula primeiro, Celula ultimo)
{
    Celula i = primeiro;
    Celula tmp = null;
    Celula j = topo;
    if (topo == null)
        throw new Exception("Erro pilha vazia!");
    do
    {
        for (;j.prox != tmp || j.prox != null;j=j.prox);
        if (j == primeiro.prox)
        {
            j = topo;
        }
        tmp = j;
        j = topo;
        i.prox = tmp;
        i = i.prox;
    }while (tmp != topo);
    ultimo = tmp;
    i = tmp = j = null;
}