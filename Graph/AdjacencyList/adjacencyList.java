// code from chatGPT

import java.util.*;
class Graph {
    
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;
    
    Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();
        
        for(int i =0; i < vertices; i++){
            adjList.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    
    void printGraph(){
        for(int i = 0; i < vertices; i++){
            System.out.print(i + " -> ");
            for(int node : adjList.get(i)){
                System.out.print(node + " ");
            }
          System.out.println();  
        }
        
    }
}
class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        
        g.printGraph();
        
    }
}