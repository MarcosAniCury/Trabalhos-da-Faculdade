package src;

//Java Class
import java.util.Scanner;
import java.util.List;

//My Class
import src.core.controller.GrafoDirecionadoController;
import src.core.model.GrafoDirecionadoModel;
import src.core.utils.Utils;

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

            int tamGrafo = 0;

            System.out.println("Algoritmo para achar caminhos disjuntos em arestas no grafo");
            while (tamGrafo == 0) {
                System.out.print("Digite o tamanho do grafo:");
                tamGrafo = input.nextInt();
                System.out.print("\n");
                if (tamGrafo <= 0) {
                    System.out.println("Valor inválido, digite novamente");
                }
            }

            GrafoDirecionadoModel grafo = new GrafoDirecionadoModel(tamGrafo);
            System.out.println("Digite o conjunto de arestas do grafo\n" +
                                "Ex:(A->B),(B->C)");
            String formatarGrafo = input.next();
            grafo.setGrafo(GrafoDirecionadoController.formatarGrafo(formatarGrafo,tamGrafo));

            int[] parVertice = new int[2];
            System.out.println("Digite qual vertice deseja partir,\n" + "Ex:A");
            parVertice[0] = ((int) input.next().charAt(0) - GrafoDirecionadoController.CONVERSAO_ARESTA_ASCII);
            System.out.println("Digite qual vertice deseja chegar,\n" + "Ex:C");
            parVertice[1] = ((int) input.next().charAt(0) - GrafoDirecionadoController.CONVERSAO_ARESTA_ASCII);
            System.out.print("\n");

            if (parVertice[0] < 0 || parVertice[0] > grafo.getTamGrafo()) {
                throw new Exception("Erro: Vertice de partida incorreto");
            } else if (parVertice[1] < 0 || parVertice[1] > grafo.getTamGrafo()) {
                throw new Exception("Erro: Vertice de chegada incorreto");
            }
        
            List<String> arestasDisjuntas = GrafoDirecionadoController.acharArestasDisjuntas(grafo, parVertice);
            System.out.println("Temos os seguintes conjuntos de arestas disjuntas no grafo:");
            for (String aresta : arestasDisjuntas) {
                System.out.println("Conjuntos de arestas:"+aresta);
            }

        } catch (Exception erro) {
            if (erro.getMessage() != null && erro.getMessage().startsWith(Utils.ERROR_BY_USER_STRING)) {
                System.out.println(erro.getMessage());
            } else {
                erro.printStackTrace();
            }
        }
        input.close();
    }
}