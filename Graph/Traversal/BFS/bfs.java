// vid link : https://www.youtube.com/watch?v=-tgVpUgsQ5k

import java.util.*;

class Main {
    public static void bfs(int V, ArrayList<ArrayList<Integer>> adj, int src){
        
        int [] visited = new int[V];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        visited[src] = 1;
        queue.offer(src);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node + " ");
            
            for(int neighbour : adj.get(node)){
                if(visited[neighbour] == 0){
                    visited[neighbour] = 1;
                    queue.offer(neighbour);
                }
            }
        }
    }
    
    static void addEdge( ArrayList<ArrayList<Integer>> adj ,int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public static void main(String[] args) {
        
        int V = 10;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 6);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 8);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 9); 
        addEdge(adj, 7, 8); 
        
        System.out.print("BFS Traversal: ");
        bfs(V, adj, 1);
    }
}


// output
// BFS Traversal: 1 
// 2 
// 6 
// 3 
// 4 
// 7 
// 9 
// 5 
// 8