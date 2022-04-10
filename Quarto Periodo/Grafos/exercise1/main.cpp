#include <iostream>

using namespace std;

#define MAX_PAIR_VETEX 8
#define FIRST_VERTEX 1
#define LAST_VERTEX 6

//Pair of vertex to build a graph
int firstValueOfPairVertex[MAX_PAIR_VETEX] = {1, 2, 3, 4, 1, 5, 6, 2};
int secondValueOfPairVertex[MAX_PAIR_VETEX] = {2,3,1,6,5,3,1,4};
int weightOfPairVertex[MAX_PAIR_VETEX] = {10,2,3,5,6,4,2,9};

class AdjacencyVertex {
    int vertex;
    int weight;
    AdjacencyVertex *prox;
    AdjacencyVertex *proxList;
public:
    AdjacencyVertex() {
        vertex = 0;
        weight = -1;
        prox = NULL;
        proxList = NULL;
    }

    int getVertex() const {
        return vertex;
    }

    void setVertex(int vertex) {
        AdjacencyVertex::vertex = vertex;
    }

    int getWeight() const {
        return weight;
    }

    void setWeight(int weight) {
        AdjacencyVertex::weight = weight;
    }

    AdjacencyVertex *getProx() const {
        return prox;
    }

    void setProx(AdjacencyVertex *prox) {
        AdjacencyVertex::prox = prox;
    }

    AdjacencyVertex *getProxList() const {
        return proxList;
    }

    void setProxList(AdjacencyVertex *proxList) {
        AdjacencyVertex::proxList = proxList;
    }
};

class AdjacencyList {
    AdjacencyVertex *adjacencyList;
    bool isWeighted;
public:
    AdjacencyList() {
        AdjacencyVertex vertex[LAST_VERTEX+1];
        for (int i = FIRST_VERTEX;i <= LAST_VERTEX;i++){
            vertex[i].setVertex(i);
        }
        adjacencyList = vertex;

        printAllVertex();

        isWeighted = false;
    }

    AdjacencyList(bool isWeighted) {
        AdjacencyVertex vertex[LAST_VERTEX+1];
        for (int i = FIRST_VERTEX;i <= LAST_VERTEX;i++){
            vertex[i].setVertex(i);
            vertex[i].setProx(NULL);
            vertex[i].setProxList(NULL);
        }
        adjacencyList = vertex;

        printAllVertex();

        AdjacencyList::isWeighted = isWeighted;
    }

    AdjacencyVertex *getAdjacencyList() const {
        return adjacencyList;
    }

    void setAdjacencyList(AdjacencyVertex *adjacencyList) {
        AdjacencyList::adjacencyList = adjacencyList;
    }

    bool isWeighted1() const {
        return isWeighted;
    }

    void setIsWeighted(bool isWeighted) {
        AdjacencyList::isWeighted = isWeighted;
    }

    void setVertex(int index, int weight = -1, AdjacencyVertex *prox = NULL) {
        AdjacencyVertex* vertexModify = &adjacencyList[index];
        while (vertexModify->getProxList() != NULL && vertexModify->getProx()->getVertex() != index) {
            vertexModify = vertexModify->getProxList();
        }
        if (isWeighted) {
            vertexModify->setWeight(weight);
        }
        if (prox != NULL) {
            vertexModify->setProxList(prox);
            if (adjacencyList[index].getVertex() == vertexModify->getVertex()) {
                vertexModify->setProx(prox);
            }
        }
    }

    AdjacencyVertex *getVertex(int index) {
        return &AdjacencyList::adjacencyList[index];
    }

    void print() {
        for (int i = FIRST_VERTEX;i <= LAST_VERTEX;i++) {
            AdjacencyVertex vertex = adjacencyList[i];
            string msg = vertex.getVertex() + ") -> ";
            AdjacencyVertex* prox = vertex.getProx();
            while (prox != NULL) {
                msg += prox->getVertex() + ',';
                prox = prox->getProx();
            }
            msg.pop_back();
            msg += "\n";
            cout << msg << endl;
        }
    }

    void printAllVertex(){
        string msg = "";
        for (int i = FIRST_VERTEX;i <= LAST_VERTEX;i++) {
            msg += adjacencyList[i].getVertex() + "\n";
        }
        cout << msg << endl;
    }
};

int startMenu() {
    int input = 0;
    bool flag;
    do {
        string userInput;
        cout << "Bem vindo ao sistema de armazenamento de grafos" << endl;
        string msg = "Escolha entre as opcoes abaixo\n1)Grafo direcionado nao-ponderado\n2)Grafo nao-direcionado nao-ponderado\n3)Grafo direicionado ponderado\n4)Grafo nao-direcionado ponderado\n\n0)Para sair";
        cout << msg << endl;
        scanf("%d", &input);
        flag = input < 0 && input > 4;

        if (flag) {
            cout << "\n\nOpcao invalida digite novamente\n\n" << endl;
        }
    }while (flag);
    return input;
}

void createGraphDirectedNotWeighted() {
    bool isWeighted = false;
    AdjacencyList graphDirectedNotWeighted(isWeighted);
    for(int i = 0; i < MAX_PAIR_VETEX;i++) {
        int firstValuePairOfVertex = firstValueOfPairVertex[i];
        AdjacencyVertex *proxVertex = graphDirectedNotWeighted.getVertex(
                secondValueOfPairVertex[i]);

        graphDirectedNotWeighted.setVertex
        (
            firstValuePairOfVertex,
            -1,
            proxVertex
        );
    }

    graphDirectedNotWeighted.print();
}

void createGraphNotDirectedNotWeighted() {

}

void createGraphDirectedWeighted() {

}

void createGraphNotDirectedWeighted() {

}

int main() {
    int input;
    do {
        input = startMenu();
        switch (input) {
            case 1:
                createGraphDirectedNotWeighted();
                break;

            case 2:
                createGraphNotDirectedNotWeighted();
                break;

            case 3:
                createGraphDirectedWeighted();
                break;

            case 4:
                createGraphNotDirectedWeighted();
                break;

            default: cout << "\n\nObrigado por utilizar o sistema" << endl;
        }

        cout << "\n\n" << endl;

    }while (input != 0);
    return 0;
};