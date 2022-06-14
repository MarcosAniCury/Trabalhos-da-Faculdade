package src.core.model;
public class GrafoDirecionadoModel
{
    private int tamGrafo;
    private int[][] grafo;

    public GrafoDirecionadoModel() 
    {
        this.tamGrafo = 0;
        grafo = new int[1][1];
    }

    public GrafoDirecionadoModel(int tamGrafo)
    {
        this.tamGrafo = tamGrafo;
        this.grafo = new int[tamGrafo][tamGrafo];
    }

    public int getTamGrafo() {
        return this.tamGrafo;
    }

    public int[][] getGrafo() {
        return this.grafo;
    }

    public void setTamGrafo(int tamGrafo) {
        this.tamGrafo = tamGrafo;
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo; 
        if (this.tamGrafo != grafo.length) {
            this.setTamGrafo(grafo.length);
        }
    }

    public void printGrafo() {
        String print = "";
        for (int i = 0;i < this.tamGrafo;i++) {
            print += i + "|";
            for (int j = 0;j < this.tamGrafo;j++) {
                print += grafo[i][j] + "|";
            }
            print += "\n";
        }
        System.out.println(print);
    }
}