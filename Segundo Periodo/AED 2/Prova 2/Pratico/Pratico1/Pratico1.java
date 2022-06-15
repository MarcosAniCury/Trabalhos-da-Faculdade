
class CelulaQuadrupla 
{
   public int elemento;
   public CelulaQuadrupla prox, ant, sup, inf;
   
   public CelulaQuadrupla()
   {
      this(0);
   }
   public CelulaQuadrupla(int x)
   {
      
      this.elemento = x;
      this.prox = this.ant = this.sup = this.inf = null;
   }
}

class Matriz
{
   private static CelulaQuadrupla primeira;
   private CelulaQuadrupla ultima;
   private CelulaQuadrupla auxiliar;
   private CelulaQuadrupla embaixo;
   private static int linhas, colunas;

  /*
   * Construtor vazio 
   */
   public Matriz()
   {
      this(2, 2);
   }
   


   /*
    * Construtor linhas e coluna
    */
   public Matriz (int linhas, int colunas)
   { 
        this.linhas = linhas;
        this.colunas = colunas;
        for (int i = 0; i < linhas; i++)
        {

            for (int j = 0; j < colunas; j++)
            {
                // preenchendo a primeira linha:
                if (i == 0)
                {
                    if (j == 0)
                    {
                        primeira = new CelulaQuadrupla();
                        embaixo = primeira;
                        auxiliar = primeira;
                    }
                    else
                    {
                        CelulaQuadrupla celula = new CelulaQuadrupla(); //
                        auxiliar.prox = celula; //
                        auxiliar.prox.ant = auxiliar; 
                        auxiliar = auxiliar.prox; 
                    }
                }

                // criando o restante das linhas
                else
                { 
                CelulaQuadrupla celula = new CelulaQuadrupla(); //
                auxiliar.inf = celula; //
                celula.sup = auxiliar; //
    
                if (j != 0)
                {
                    auxiliar.ant.inf.prox = celula; //
                    celula.ant = auxiliar.ant.inf; //
                }
                
                
                if (auxiliar.prox != null)
                    auxiliar = auxiliar.prox;
                }
            } 

            if (i != 0)
            {
                embaixo = embaixo.inf;
            }

            auxiliar = embaixo;
        }
        ultima = primeira.inf.inf.inf.prox.prox.prox;
        leitura();  
        isnone();
    }

    public void leitura()
    {
        CelulaQuadrupla tmp = primeira;
        for (CelulaQuadrupla tmp1 = primeira;tmp != null;tmp = tmp1.inf, tmp1 = tmp1.inf)
        {
            for (;tmp != null;tmp = tmp.prox)
            {
                tmp.elemento = MyIO.readInt();
            }
        }
    }

    public boolean isup()
    {
        boolean resp = false;
        CelulaQuadrupla ajuda = primeira.inf;
        for(CelulaQuadrupla tmp = ajuda;ajuda != null;ajuda = tmp.inf, tmp = tmp.inf)
        {
            for(;ajuda != null;ajuda = ajuda.prox)
            {
                if (ajuda.elemento != 0 && (ajuda.elemento == ajuda.sup.elemento || ajuda.sup.elemento == 0))
                    resp = true;
                if (resp)
                    ajuda = ultima;
            }
        }
        if (resp)
            MyIO.print("UP ");
        return resp;
    }
    public boolean isdown()
    {
        boolean resp = false;
        CelulaQuadrupla ajuda = primeira.inf.inf;
        for(CelulaQuadrupla tmp = ajuda; ajuda != null; ajuda = tmp.sup, tmp = tmp.sup)
        {
            for (;ajuda != null;ajuda = ajuda.prox)
            {
                if (ajuda.elemento != 0 && (ajuda.elemento == ajuda.inf.elemento || ajuda.inf.elemento == 0))
                    resp = true;
                if (resp)
                    ajuda = ultima;
            }
        }
        if (resp)
            MyIO.print("DOWN ");
        return resp;
    }
    public boolean isleft()
    {
        boolean resp = false;
        CelulaQuadrupla ajuda = primeira.prox;
        for (CelulaQuadrupla tmp = ajuda; ajuda != null; ajuda = tmp.prox , tmp = tmp.prox)
        {
            for (;ajuda != null;ajuda = ajuda.inf)
            {
                if (ajuda.elemento != 0 && (ajuda.elemento == ajuda.ant.elemento || ajuda.ant.elemento == 0))
                    resp = true;
                if (resp)
                    ajuda = ultima;
            }
        }
        if (resp)
            MyIO.print("LEFT ");
        return resp;
    }
    public boolean isright()
    {
        boolean resp = false;
        CelulaQuadrupla ajuda = ultima.ant;
        for (CelulaQuadrupla tmp = ajuda; ajuda != null; ajuda = tmp.ant, tmp = tmp.ant)
        {
            for (;ajuda != null; ajuda = ajuda.sup)
            {
                if(ajuda.elemento != 0 && (ajuda.elemento == ajuda.prox.elemento || ajuda.prox.elemento == 0))
                    resp = true;
                if (resp)
                    ajuda = primeira;
            }
        }
        if (resp)
            MyIO.print("RIGHT ");
        return resp;
    }
    public void isnone()
    {
        boolean down = isdown();
        boolean left = isleft();
        boolean right = isright();
        boolean up = isup();
        if (!up && !down && !left && !right)
            MyIO.print("NONE");
    }
}

class Pratico1
{
   
   public static void main (String[] args)
   {
        int teste = MyIO.readInt();
        Matriz[] matriz = new Matriz[teste];
        for (int i = 0; i < teste; i++)
        {
            matriz[i] = new Matriz(4,4);
        }
   }
}
