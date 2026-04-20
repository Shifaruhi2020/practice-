// solution vid: https://www.youtube.com/watch?v=73sneFXuTEg
import java.util.*;

class Solution {

    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        Queue<Integer> q = new LinkedList<>();

        // filling the indegree array
        for(int i = 0; i < V; i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++; 
            }
        }

        // adding the nodes with 0 indegree into the Queue
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        // bfs code
        int it = 0;
        int[] ans = new int[V];

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans[it++] = node;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return ans;
    } 
}
