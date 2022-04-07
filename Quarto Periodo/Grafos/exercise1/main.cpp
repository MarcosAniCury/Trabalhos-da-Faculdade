#include <iostream>

using namespace std;

#define MAX_VERTICE 26
#define TABELA_ASCII_CONVERTER 65
#define NUM_CHARACTER_IN_PAIR_EDGES 4

//class MatrizAdjacencia {
//    int matriz[MAX_VERTICE][MAX_VERTICE];
//    public:
//        MatrizAdjacencia(char pairsEdges[], int nEdges) {
//            for(int i = 0;i < nEdges;i++){
//
//            }
//        }
//};
//
//class PairsEdges {
//    char edge1;
//    char edge2;
//public:
//    PairsEdges(string pairsEdges) {
//        try {
//            if (pairsEdges.size() == NUM_CHARACTER_IN_PAIR_EDGES) {
//                if (pairsEdges[1] == '-' && pairsEdges[2] == '>') {
//                    edge1 = pairsEdges[0];
//                    edge2 = pairsEdges[3];
//                } else {
//                    string initMsg = "Edge not recognized string \"";
//                    string finalMsg = "\" invalided";
//                    string msg = initMsg + pairsEdges[1] + pairsEdges[2] + finalMsg;
//                    throw msg;
//                }
//            } else {
//                string msg = "Numbers of characters in pairs has to be 4";
//                throw msg;
//            }
//        } catch (const string msg) {
//            cerr << msg << endl;
//            exit(0);
//        }
//    };
//
//    int getEdge1Int() {
//        return tableASCIIConverterToInt(edge1);
//    }
//
//    int getEdge2Int() {
//        return tableASCIIConverterToInt(edge2);
//    }
//
//    int tableASCIIConverterToInt(char caracter) {
//        return (int) caracter - TABELA_ASCII_CONVERTER;
//    }
//};
class GrafosToUse {
public:
    void
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

int main() {
    int input;
    do {
        input = startMenu();
    }while (input != 0);
    return 0;
};