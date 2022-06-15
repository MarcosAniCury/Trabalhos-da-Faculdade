package src.core.controller;

//Java Class
import java.util.List;
import java.util.ArrayList;

//My Class
import src.core.model.GrafoDirecionado;
import src.core.utils.Util;

public class GrafoDirecionadoController
{
    public static final int CONVERSAO_ARESTA_ASCII = 65;

    public static int[][] formatarGrafo(String parVertices, int numArestas) throws Exception {
        int[][] grafo = new int[numArestas][numArestas];
        parVertices = parVertices.replace("(","");
        parVertices = parVertices.replace(")", "");
        parVertices = parVertices.replace("->", "");
        String[] conjuntoArestas = parVertices.split(",");

        if (conjuntoArestas.length == 0) {
            throw new Exception("Erro: Conjunto de aresta inválido");
        }

        for (String aresta : conjuntoArestas) {
            int linha = ((int) aresta.charAt(0)) - CONVERSAO_ARESTA_ASCII;
            int coluna = ((int) aresta.charAt(1)) - CONVERSAO_ARESTA_ASCII;
            
            if (linha < 0 || linha >= numArestas) {
                throw new Exception(Util.ERROR_BY_USER_STRING+" Conjunto de aresta inválido, Letra:"+aresta.charAt(0)+" Invalida");
            } else if (coluna < 0 || coluna >= numArestas) {
                throw new Exception(Util.ERROR_BY_USER_STRING+" Conjunto de aresta inválido, Letra:"+aresta.charAt(1)+" Invalida");
            }

            grafo[linha][coluna] = 1;
        }

        return grafo;
    }

    public static List<String> acharCaminhosDisjuntos(GrafoDirecionado grafoDirecional, int[] parVertice)
    {
        List<String> caminhosDisjuntos = new ArrayList<>();
        List<String> arestasVistas = new ArrayList<>();
        int[][] grafo = grafoDirecional.getGrafo();
        int numVertice = grafoDirecional.getNumVertices();

        int linha = parVertice[0];
        int coluna;
        List<String> arestasVisitadasLoop = new ArrayList<>();
        int ultimaLinha = -1;

        while (ultimaLinha != linha) {
            ultimaLinha = linha;
            boolean andou = false;
            for (coluna = 0; coluna < numVertice;coluna++) {
                if (grafo[linha][coluna] == 1) {
                    String aresta = Character.toString(linha + CONVERSAO_ARESTA_ASCII) + 
                                        "->" +
                                        Character.toString(coluna + CONVERSAO_ARESTA_ASCII);

                    if (arestasVistas.contains(aresta)) {
                        continue;
                    }

                    arestasVisitadasLoop.add(aresta);
                    linha = coluna;
                    andou = true;
                    break;
                }
            }

            //Encontrou o vertice destino
            if (andou && coluna == parVertice[1]) {
                caminhosDisjuntos.add(Util.transformaListEmString(arestasVisitadasLoop));
                arestasVistas.addAll(arestasVisitadasLoop);
                arestasVisitadasLoop = new ArrayList<>();
                linha = parVertice[0];
            }

            //Adiciona todo o caminho percorrido nas arestas visitadas
            if (!andou && arestasVisitadasLoop.size() > 0) {
                arestasVistas.add(arestasVisitadasLoop.get(arestasVisitadasLoop.size()-1)); //adicionar a penultima visitada
                arestasVisitadasLoop = new ArrayList<>();
                linha = parVertice[0];
            }
        }

        return caminhosDisjuntos;
    }
}