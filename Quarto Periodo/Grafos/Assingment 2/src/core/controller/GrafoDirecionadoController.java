package src.core.controller;

//Java Class
import java.util.List;
import java.util.ArrayList;

//My Class
import src.core.model.GrafoDirecionadoModel;
import src.core.utils.Utils;

public class GrafoDirecionadoController
{
    public static final int CONVERSAO_ARESTA_ASCII = 65;

    public static int[][] formatarGrafo(String input, int tamGrafo) throws Exception {
        int[][] grafo = new int[tamGrafo][tamGrafo];
        input = input.replace("(","");
        input = input.replace(")", "");
        input = input.replace("->", "");
        String[] conjuntoArestas = input.split(",");

        if (conjuntoArestas.length < 1) {
            throw new Exception("Erro: Conjunto de aresta inválido");
        }

        for (String aresta : conjuntoArestas) {
            int linha = ((int) aresta.charAt(0)) - CONVERSAO_ARESTA_ASCII;
            int coluna = ((int) aresta.charAt(1)) - CONVERSAO_ARESTA_ASCII;
            
            if (linha < 0 || linha >= tamGrafo) {
                throw new Exception("Erro: Conjunto de aresta inválido, Letra:"+aresta.charAt(0)+" Invalida");
            } else if (coluna < 0 || coluna >= tamGrafo) {
                throw new Exception("Erro: Conjunto de aresta inválido, Letra:"+aresta.charAt(1)+" Invalida");
            }

            grafo[linha][coluna] = 1;
        }

        return grafo;
    }

    public static List<String> acharArestasDisjuntas(GrafoDirecionadoModel grafoDirecional, int[] parVertice)
    {
        List<String> arestasDisjuntas = new ArrayList<String>();
        List<String> arestasVistas = new ArrayList<String>();
        int[][] grafo = grafoDirecional.getGrafo();

        int linha = parVertice[0];
        int coluna = 0;
        List<String> arestasVisitadasLoop = new ArrayList<String>();
        boolean andou = false;
        int i = 0;

        while (i < grafoDirecional.getTamGrafo()) {
            boolean existeLigacao = false;
            for (coluna = 0; coluna < grafoDirecional.getTamGrafo();coluna++) {
                if (grafo[linha][coluna] == 1) {
                    String aresta = Character.toString(linha + CONVERSAO_ARESTA_ASCII) + 
                                        "->" +
                                        Character.toString(coluna + CONVERSAO_ARESTA_ASCII);
                    if (arestasVistas.contains(aresta)) {
                        if (coluna == parVertice[1] && arestasVisitadasLoop.size() > 0) {
                            arestasVistas.add(arestasVisitadasLoop.get(arestasVisitadasLoop.size() - 1)); //adicionar a penultima visitada
                            arestasVisitadasLoop = new ArrayList<String>();
                            linha = parVertice[0];
                            i = 0; //Começar a iteração do zero
                        }
                        continue;
                    }
                    arestasVisitadasLoop.add(aresta);
                    linha = coluna;
                    andou = true;
                    existeLigacao = true;
                    break;
                }
            }
            
            if (andou) {
                if (coluna == parVertice[1]) {
                    arestasDisjuntas.add(Utils.transformaListEmString(arestasVisitadasLoop));
                    arestasVistas.addAll(arestasVisitadasLoop);
                    arestasVisitadasLoop = new ArrayList<String>();
                    linha = parVertice[0];
                    i = -1; //Começar a iteração do zero
                }
                andou = false;
            }

            i++;
            if (i == grafoDirecional.getTamGrafo() && coluna == grafoDirecional.getTamGrafo()) { //Ultima iteração de todas
                break;
            }
            
            if (!existeLigacao && arestasVisitadasLoop.size() > 0) {
                arestasVistas.add(arestasVisitadasLoop.get(arestasVisitadasLoop.size()-1)); //adicionar a penultima visitada
                arestasVisitadasLoop = new ArrayList<String>();
                linha = parVertice[0];
                i = 0; //Começar a iteração do zero
            } else {
                existeLigacao = false;
            }
        }

        return arestasDisjuntas;
    }
}