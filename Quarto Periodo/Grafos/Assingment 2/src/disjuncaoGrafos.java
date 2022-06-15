package src;

//Java Class

import src.core.controller.GrafoDirecionadoController;
import src.core.model.GrafoDirecionado;
import src.core.utils.Util;

import java.util.List;
import java.util.Scanner;

/*
* Feito pelos alunos: Marcos Ani Cury Vinagre Silva, Leticia Americano Lucas
* Matrícula dos respectivos: 684903, 691290
*/

public class disjuncaoGrafos
{
    public static void main (String [] args) 
    {
        Scanner input = new Scanner(System.in);
        try {

            int numVertices = 0;

            System.out.println("Algoritmo para achar caminhos disjuntos em arestas no grafo");
            while (numVertices == 0) {
                System.out.print("Digite o numero de vertices do grafo:");
                numVertices = input.nextInt();
                System.out.print("\n");
                if (numVertices <= 0) {
                    System.out.println("Valor inválido, digite novamente");
                }
            }

            GrafoDirecionado grafo = new GrafoDirecionado(numVertices);
            System.out.println("Digite o conjunto de arestas do grafo\n" +
                                "Ex:(A->B),(B->C)");
            String parDeVertices = input.next();
            grafo.setGrafo(GrafoDirecionadoController.formatarGrafo(parDeVertices,numVertices));

            int[] parVertice = new int[2];
            System.out.println("Digite qual vertice deseja partir,\n" + "Ex:A");
            parVertice[0] = ((int) input.next().charAt(0) - GrafoDirecionadoController.CONVERSAO_ARESTA_ASCII);
            System.out.println("Digite qual vertice deseja chegar,\n" + "Ex:C");
            parVertice[1] = ((int) input.next().charAt(0) - GrafoDirecionadoController.CONVERSAO_ARESTA_ASCII);
            System.out.print("\n");

            if (parVertice[0] < 0 || parVertice[0] > grafo.getNumVertices()) {
                throw new Exception(Util.ERROR_BY_USER_STRING+" Vertice de partida incorreto");
            } else if (parVertice[1] < 0 || parVertice[1] > grafo.getNumVertices()) {
                throw new Exception(Util.ERROR_BY_USER_STRING+" Vertice de chegada incorreto");
            }
        
            List<String> caminhosDisjuntos = GrafoDirecionadoController.acharCaminhosDisjuntos(grafo, parVertice);
            System.out.println("Temos os seguintes caminhos disjuntos no grafo:");
            for (String aresta : caminhosDisjuntos) {
                System.out.println("par de vertices:"+aresta);
            }

        } catch (Exception erro) {
            if (erro.getMessage() != null && erro.getMessage().startsWith(Util.ERROR_BY_USER_STRING)) {
                System.out.println(erro.getMessage());
            } else {
                erro.printStackTrace();
            }
        }
        input.close();
    }
}