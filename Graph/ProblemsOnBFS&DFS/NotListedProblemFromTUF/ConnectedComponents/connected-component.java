// solution same as
// https://github.dev/Shifaruhi2020/practice-/blob/723ab034b84365aba3b25afe7bcf368c7dffbf54/Graph/ProblemsOnBFS%26DFS/Medium/547-number-of-provinces/547-number-of-provinces.java

class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[V];
        int connect = 0;
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                connect ++;
                dfs(i, adj, visited);
            }
        }
        return connect;
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[src] = 1;

        for(int neighbour : adj.get(src)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adj, visited);
            }
        }
    }
}
