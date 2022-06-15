import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Noticia {
    public String descricao;
    private int mes;
    private String topico;

    Noticia(String descricao, int mes, String topico) {
        this.descricao = descricao;
        this.setMes(mes);
        this.setTopico(topico);
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }
}

class ConsomeNoticia {
    public Noticia[] noticias;

    ConsomeNoticia(Noticia[] noticias) {
        this.noticias = noticias;
    }
}

class ConsomeNoticiaAgregador extends ConsomeNoticia {
    boolean isTopico;

    ConsomeNoticiaAgregador(Noticia[] noticias, boolean isTopico) {
        super(noticias);
        this.isTopico = isTopico;
        NoticiarioAssina(isTopico);
    }

    ConsomeNoticiaAgregador(Noticia[] noticias) {
        super(noticias);
        this.isTopico = false;
        NoticiarioAssina(isTopico);
    }

    void NoticiarioAssina(boolean isTopico){
        //Agregacao por topico
        if (isTopico) {
            OrdenaNoticia( "topico");

            String topicoAtual = noticias[0].getTopico();
            System.out.println(topicoAtual+')');
            int numMesmoTopico = 0;

            String topicoConcat = noticias[0].descricao;
            for(int i=1;i<noticias.length;i++){
                if (!noticias[i].getTopico().equals(topicoAtual)) {
                    System.out.println(topicoConcat);
                    topicoConcat = "";
                    System.out.println(noticias[i].getTopico() +')');
                    topicoAtual = noticias[i].getTopico();
                    numMesmoTopico = 0;
                }
                numMesmoTopico++;
                if (numMesmoTopico != 1) {
                    topicoConcat += "\n" + noticias[i].descricao;
                } else {
                    topicoConcat += noticias[i].descricao;
                }

                if (numMesmoTopico == 10) {
                    System.out.println(topicoConcat);
                    numMesmoTopico = 0;
                    topicoConcat = "";
                }
            }
            System.out.println(topicoConcat);
        }
        //Agregacao por mes
        else {
            OrdenaNoticia("mes");

            int mesAtual = noticias[0].getMes();
            System.out.println(Integer.toString(mesAtual)+')');
            String mesConcat = noticias[0].descricao+"\n";
            for(int i=1;i<noticias.length;i++){
                if (noticias[i].getMes() != mesAtual) {
                    System.out.println(mesConcat);
                    mesConcat = "";
                    System.out.println(Integer.toString(noticias[i].getMes()) +')');
                    mesAtual = noticias[i].getMes();
                }
                mesConcat += noticias[i].descricao+"\n";
            }
            System.out.println(mesConcat);
        }
    }

    void OrdenaNoticia(String tipo) {
        if (tipo == "mes") {
            ArrayList<Noticia> listaOrdenar = new ArrayList<>(List.of(noticias));
            listaOrdenar.sort(Comparator.comparing(Noticia::getMes));
            noticias = listaOrdenar.toArray(new Noticia[0]);
        } else if (tipo ==  "topico") {
            ArrayList<Noticia> listaOrdenar = new ArrayList<>(List.of(noticias));
            listaOrdenar.sort(Comparator.comparing(Noticia::getTopico));
            noticias = listaOrdenar.toArray(new Noticia[0]);
        }
    }
}

class ConsomeNoticiaPublicador extends ConsomeNoticia {

    ConsomeNoticiaPublicador(Noticia[] noticias){
        super(noticias);
        PublicaNoticias();
    }

    void PublicaNoticias() {
        for(int i=0;i<noticias.length;i++){
            System.out.println(i+1+") "+noticias[i].descricao);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Noticia noticia1 = new Noticia("Sobe o número de votos brancos ou nulos na eleicao de 2022", 7, "eleicao");

        Noticia noticia2 = new Noticia("Impostos no mundo dos games caem mais 10% em 2022", 8, "games");

        Noticia noticia3 = new Noticia("Guerra na ucrania acaba gracas a cobra fumando charuto", 12, "guerra");

        Noticia noticia4 = new Noticia("Danillo Gentile ganha as eleicoes e brinca, \"nem os gados nem os maconheiros ganharam dessa vez\"", 12, "eleicao");

        Noticia[] noticias = {noticia1,noticia2,noticia3,noticia4};
        System.out.println("Publicador:");
        new ConsomeNoticiaPublicador(noticias);
        System.out.println("Agregador(Mes):");
        new ConsomeNoticiaAgregador(noticias);
        System.out.println("Agregador(Topico):");
        new ConsomeNoticiaAgregador(noticias, true);
    }
}