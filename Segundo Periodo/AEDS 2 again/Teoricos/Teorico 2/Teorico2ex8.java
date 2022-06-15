public class Teorico2ex8
{
    boolean isConsoante(String s, int i)
    {
        boolean resp = true;
        if (i == s.length())
            resp = true;
        else if (!isConsoante(s.charAt(i))) 
            resp = false;
        else 
            resp = isConsoante(s, i + 1);
        return resp;
    }
}