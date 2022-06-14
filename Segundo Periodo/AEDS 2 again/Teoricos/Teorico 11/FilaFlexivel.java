public class RemocaoFisica
{
    public static void removerFila()
    {
        Celula temp = primeiro;
        primeiro = primeiro.prox;
        temp.prox = null;
        temp = null;
    }
}