// code from chatGPT
class Graph {
    
    private int vertices;
    private int[][] adjMatrix;
    
    Graph(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }
    
    void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }
    
    void printGraph(){
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
          System.out.println();  
        }
        
    }
}
class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        
        g.printGraph();
        
    }
}
