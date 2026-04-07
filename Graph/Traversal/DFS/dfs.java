// vid link : https://www.youtube.com/watch?v=-tgVpUgsQ5k

import java.util.*;

class Main {
    
    public static void dfs(int V, ArrayList<ArrayList<Integer>> adj, int src){
        
        int [] visited = new int[V];
        
        dfsRecursive(src, adj, visited);
    }
    
    public static void dfsRecursive(int node, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
        visited[node] = 1;
        System.out.println(node + " ");
        
        for(int neighbour: adj.get(node)){
            if(visited[neighbour] == 0){
                dfsRecursive(neighbour, adj, visited);
            }
        }
    }
    
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public static void main(String[] args) {
        
        int V = 9;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        addEdge(adj,1, 2);
        addEdge(adj,1, 3);
        addEdge(adj,2, 5);
        addEdge(adj,2, 6);
        addEdge(adj,3, 4);
        addEdge(adj,3, 7);
        addEdge(adj,4, 8);
        addEdge(adj,7, 8);
        
        System.out.println("DFS traversal: ");
        dfs(V, adj, 1);
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



// code if we want to combine the two dfs methods

// to combine the two methods we will have pass the visited array in the method so that the state of visited doesnt
// change with every recursion

// import java.util.*;

// class Main {
    
//     public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
//         visited[node] = 1;
//         System.out.print(node + " ");
        
//         for(int neighbour : adj.get(node)){
//             if(visited[neighbour] == 0){
//                 dfs(neighbour, adj, visited);
//             }
//         }
//     }

// keep this code commented
    
    // public static void dfsRecursive(int node, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
    //     visited[node] = 1;
    //     System.out.println(node + " ");
        
    //     for(int neighbour: adj.get(node)){
    //         if(visited[neighbour] == 0){
    //             dfsRecursive(neighbour, adj, visited);
    //         }
    //     }
    // }
    
//  till here 
// kept the above code just for the purpose of understanding


//     public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        
//         adj.get(u).add(v);
//         adj.get(v).add(u);
//     }
    
//     public static void main(String[] args) {
        
//         int V = 9;
        
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
//         for(int i = 0; i < V; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         addEdge(adj, 1, 2);
//         addEdge(adj, 1, 3);
//         addEdge(adj, 2, 5);
//         addEdge(adj, 2, 6);
//         addEdge(adj, 3, 4);
//         addEdge(adj, 3, 7);
//         addEdge(adj, 4, 8);
//         addEdge(adj, 7, 8);
        
//         System.out.println("DFS Traversal:");
        
//         int[] visited = new int[V];   // ✅ created ONCE
//         dfs(1, adj, visited);         // ✅ passed to recursion
//     }
// }

// output
// DFS Traversal:
// 1 2 5 6 3 4 8 7 