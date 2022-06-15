void mostrar2pilhas(Celula topo1, Celula topo2)
{
    Celula i = null;
    Celula j = null;
    if (topo1 == null && topo2 == null)
        throw new Exception("Erro pilha vazia!");
    if(topo1 != null)
    {
        MyIO.println(topo1);
        i = topo1.prox;
    }
    if(topo2 != null)
    {
        MyIO.println(topo2);
        j = topo2.prox;
    }
    if (topo1 != null || topo2 != null)
        mostrar2pilhas(i,j);
    j = i = null;
}