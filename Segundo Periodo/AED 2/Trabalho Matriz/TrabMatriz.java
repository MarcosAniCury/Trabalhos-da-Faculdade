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
               }else
               {
                  CelulaQuadrupla celula = new CelulaQuadrupla(); //
                  auxiliar.prox = celula; //
                  auxiliar.prox.ant = auxiliar; 
                  auxiliar = auxiliar.prox; 
               }
            
            // criando o restante das linhas
            }
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
   }

   public static void Imprimir()
   {
      CelulaQuadrupla i;
      CelulaQuadrupla k = primeira;
      for (int l = 0; l < linhas;k = k.inf, l++)
      {
         i = k;
         for (int j = 0; j < colunas; i = i.prox, j++)
         { 
            System.out.println(i.elemento);
         }
      }
   }

}

class TrabMatriz
{
   
   public static void main (String[] args)
   {
      Matriz matriz = new Matriz(3,3);
      Matriz.Imprimir();
   }
}
