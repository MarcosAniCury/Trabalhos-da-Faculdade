package src.core.model;
public class GrafoDirecionado
{
    private int numVertices;
    private int[][] grafo;

    public GrafoDirecionado(int tamGrafo)
    {
        this.numVertices = tamGrafo;
        this.grafo = new int[tamGrafo][tamGrafo];
    }

    public int[][] getGrafo() {
        return this.grafo;
    }

    public int getNumVertices() { return this.numVertices; }

    public void setNumVertices(int tamGrafo) {
        this.numVertices = tamGrafo;
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo; 
        if (this.numVertices != grafo.length) {
            this.setNumVertices(grafo.length);
        }
    }

    public void printGrafo() {
        String print = "";
        for (int i = 0;i < this.numVertices;i++) {
            print += i + "|";
            for (int j = 0;j < this.numVertices;j++) {
                print += grafo[i][j] + "|";
            }
            print += "\n";
        }
        System.out.println(print);
    }
}