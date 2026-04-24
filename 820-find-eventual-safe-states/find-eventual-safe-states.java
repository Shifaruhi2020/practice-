class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // creating the adj reverse
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[graph.length];
        
        // reversal of the graph
        for(int i = 0; i < graph.length; i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        } 
 
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safenode = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            if(indegree[i] == 0){
                q.add(i); 
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            safenode.add(node);

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }    

        Collections.sort(safenode);
        return safenode;  
    }
}