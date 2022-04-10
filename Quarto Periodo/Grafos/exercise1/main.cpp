#include <iostream>

using namespace std;

#define MAX_PAIR_VETEX 8
#define FIRST_VERTEX 0
#define LAST_VERTEX 5

//Pair of vertex to build a graph
int firstValueOfPairVertex[MAX_PAIR_VETEX] = {1, 2, 3, 4, 1, 5, 6, 2};
int secondValueOfPairVertex[MAX_PAIR_VETEX] = {2,3,1,6,5,3,1,4};
int weightOfPairVertex[MAX_PAIR_VETEX] = {10,2,3,5,6,4,2,9};

class MatrizAdjacency{
    int matrizAdjacency[LAST_VERTEX+1][LAST_VERTEX+1];
    bool isWeighted;
    bool isDirection;
public:
    MatrizAdjacency(bool isWeighted, bool isDirection) {
        MatrizAdjacency::isWeighted = isWeighted;
        MatrizAdjacency::isDirection = isDirection;

        for (int i = FIRST_VERTEX;i <= LAST_VERTEX;i++) {
            for (int j = FIRST_VERTEX; j <= LAST_VERTEX; j++) {
                matrizAdjacency[i][j] = 0;
            }
        }
    }

    void setVertex(int indexLine, int indexCol, int weight = 1) {
        matrizAdjacency[indexLine-1][indexCol-1] = weight;

        if (!isDirection) {
            matrizAdjacency[indexCol-1][indexLine-1] = weight;
        }
    }

    void print() {
        string line = "";
        for (int i = FIRST_VERTEX;i <= LAST_VERTEX;i++) {
            for (int j = FIRST_VERTEX;j <= LAST_VERTEX;j++) {
                line += to_string(matrizAdjacency[i][j]) + "|";
            }
            cout << line << endl;
            line = "";
        }
    }
};

int startMenu() {
    int input = 0;
    bool flag;
    do {
        cout << "Bem vindo ao sistema de armazenamento de grafos" << endl;
        string msg = "Escolha entre as opcoes abaixo\n1)Grafo direcionado nao-ponderado\n2)Grafo nao-direcionado nao-ponderado\n3)Grafo direicionado ponderado\n4)Grafo nao-direcionado ponderado\n\n0)Para sair";
        cout << msg << endl;
        scanf("%d", &input);
        flag = input < 0 || input > 4;

        if (flag) {
            cout << "\n\nOpcao invalida digite novamente\n\n" << endl;
        }
    }while (flag);
    return input;
}

void createGraph(bool isWeighted,bool isDirected) {
    MatrizAdjacency graph(isWeighted, isDirected);
    for(int i = FIRST_VERTEX; i < MAX_PAIR_VETEX;i++) {
        int firstValuePairOfVertex = firstValueOfPairVertex[i];
        int secondValuePairOfVertex = secondValueOfPairVertex[i];
        int weighted = 1;

        if (isWeighted) {
            weighted = weightOfPairVertex[i];
        }

        graph.setVertex
        (
            firstValuePairOfVertex,
            secondValuePairOfVertex,
            weighted
        );
    }

    graph.print();
}

int main() {
    int input;
    do {
        input = startMenu();
        bool isWeighted;
        bool isDirected;
        switch (input) {
            case 1:
                isWeighted = false;
                isDirected = true;
                createGraph(isWeighted,isDirected);
                break;

            case 2:
                isWeighted = false;
                isDirected = false;
                createGraph(isWeighted,isDirected);
                break;

            case 3:
                isWeighted = true;
                isDirected = true;
                createGraph(isWeighted,isDirected);
                break;

            case 4:
                isWeighted = true;
                isDirected = false;
                createGraph(isWeighted,isDirected);
                break;

            default: cout << "\n\nObrigado por utilizar o sistema" << endl;
        }

        cout << "\n\n" << endl;

    }while (input != 0);
    return 0;
};