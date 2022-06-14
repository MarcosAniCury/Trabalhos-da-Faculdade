public class FilaFlexivel
{
    public static void removerFila()
    {
        Celula temp = primeiro;
        primeiro = primeiro.prox;
        temp.prox = null;
        temp = null;
    }

    public static int MaiorElemento()
    {
        Celula temp = primeiro.prox;
        int maior = temp.elemento;
        for (;temp != null;temp = temp.prox)
            if (maior < temp.elemento)
                maior = temp.elemento;
        return maior;
    }

    public static int TerceiroElemento()
    {
        Celula temp = primeiro.prox;
        for(int i = 0;i < 2;i++, temp = temp.prox);
        int terceiro = temp.elemento;
        return terceiro;
    }

    public static int SomaElementos()
    {
        int soma = 0;
        Celula temp = primeiro.prox;
        for(;temp != null;temp = temp.prox)
            soma += temp.elemento;
        return soma;
    }

    public static void inversao()
    {
        Celula temp = primeiro.prox;
        int ncelulas = 0;
        for(Celula tmp = primeiro.prox;tmp != null;tmp = tmp.prox, ncelulas++);
        do
        {
            Celula tmp = primeiro;
            for(int i = ncelulas;i > 0;i--)
                tmp = tmp.prox;
            temp.elemento = tmp.elemento;
            temp = temp.prox;
            ncelulas--;
        }while(ncelulas > 0);
    }

    public static int nPares_e_x5(Celula i)
    {
        int n = 0;
        if(i != null)
        {
            if (i.elemento % 10 == 0)
                n++;
            n += nPares_e_x5(i.prox) 
        }
        return n;
    }

    public static Celula toFila(Celula topo)
    {
        Celula primeira = new Celula();
        int ncelulas = 0;
        for (Celula tmp = topo;tmp != null;tmp = tmp.prox, ncelulas++);]
        Celula temp = primeira
        do
        {
            Celula tmp = topo;
            for(int i = ncelulas;i > 0;i--)
                tmp = tmp.prox;
            temp.elemento = tmp.elemento;
            temp.prox = new Celula();
            temp = temp.prox;
            ncelulas--;
        }while(ncelulas > 0);
    }

    public static Celula FilaSemNoCab()
    {
        Celula Fim = new Celula();
        Celula temp = primeira;
        while (temp != null)
        {
            Fim.prox = new Celula();
            Fim.prox = temp.elemento;
            Fim = Fim.prox;
            temp = temp.prox;
        }
        return Fim;
    }

    public static Celula PilhaSemFim()
    {
        Celula Comeco = new Celula();
        Celula tmp = Comeco;
        Celula temp = primeira;
        while (temp != null)
        {
            tmp.prox = new Celula();
            tmp.prox = temp.elemento;
            tmp = tmp.prox;
            temp = temp.prox;
        }
        tmp = null;
        return Comeco;
    }
}