package src.core.utils;

import java.util.List;

public class Utils {
    public static final String ERROR_BY_USER_STRING = "Erro:";

    public static String transformaListEmString(List<String> lista) {
        String listaEmString = "";

        for (String string : lista) {
            listaEmString += string+",";
        }

        listaEmString = listaEmString.substring(0,listaEmString.length()-1);

        return listaEmString;
    }
}
