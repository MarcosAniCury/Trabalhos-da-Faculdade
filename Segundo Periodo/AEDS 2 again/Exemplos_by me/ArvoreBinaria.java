public class ArvoreBinaria
{
    private no raiz;

    public ArvoreBinaria()
    {
        raiz = null;
    }

    public no inserir(int elemento, no inserir)
    {
        if (i == null)
            inserir = new no(elemento);
        else if (i < inserir.elemento)
            inserir.esq = inserir(elemento, inserir.esq);
        else if (i > inserir.elemento)
            inserir.dir = inserir(elemento, inserir.dir);
        else 
            MyIO.println("Erro ao inserir");
        return inserir;
    }

    public no inserir(int elemento)
    {
        no tmp;
        if (raiz == null)
        {
            raiz = new no(elemento);
            tmp = raiz;
        }
        else if (elemento < raiz.esq.elemento)
            tmp = inserir(elemento, raiz.esq.elemento);
        else if (elemento > raiz.dir.elemento)
            tmp = inserir(element, raiz.dir.elemento);
        else
            MyIO.println("Erro ao inserir");
    }
}

class no
{
    public no dir;
    public no esq;
    public int elemento;

    public no()
    {
        dir = esq = null;
        elemento = 0;
    }

    public no(int elemento)
    {
        dir = esq = null;
        this.elemento = elemento;
    }
}