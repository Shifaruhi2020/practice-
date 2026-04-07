// vid link : https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7

// code learnt from chatGPT

class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = matrixtoAdjList(isConnected);
        int n =  isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            // whenever i is updated it means there is a new province 
            if(visited[i] == 0){
                provinces ++;
                // this code doesnt traverse rather calls the traversal method
                // dfs method is seperate to make it simpler
                dfs(i, adj, visited);
            }
        }
        return provinces;
    }

// this code is for dfs traversal
    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] visited){

        visited[src] = 1;

        for(int neighbour : adj.get(src)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adj, visited);
            }
        }
        
    }

    public ArrayList<ArrayList<Integer>> matrixtoAdjList(int[][] matrix){
        int n = matrix.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                if(matrix[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                }
            }
        }
        System.out.println(adj);
        return adj;
    }
}