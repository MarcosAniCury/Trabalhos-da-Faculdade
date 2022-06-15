import java.util.*;

public class Exercicio4
{
    public static int compareTime(Time time1, Time tim2) 
        return comparTime(time1,time2, 0)
    }

    public static int comparTime(Time time1, Time time2, int cont)
    {
        int retorno = 1;
        if (time1.nome.charAt(cont) < time2.nome.charAt(cont))
            retorno = 2;
        if (cont != time1.nome.lenght() || cont != time2.nome.lenght())
        {
            if (time.nome.charAt(cont) == time2.nome.charAt(cont))
                retorno = comparTime(time1,time2,cont);
        }
        return retorno;
    }
}