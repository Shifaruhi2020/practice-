// sol link : https://www.youtube.com/watch?v=5lZ0iJMrUMk

import java.util.*;

class Solution {

    public void dfs(int x, Stack<Integer> st, List<List<Integer>> adj, int[] vis){
        vis[x] = 1;

        for(int neighbour : adj.get(x)){
            if(vis[neighbour] == 0){
                dfs(neighbour, st, adj, vis);
            }
        }

        st.push(x);
    }

    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] vis = new int[V];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, st, adj, vis);
            }
            }

        int ans[] = new int[V];
        int i = 0;

        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    } 
}


// V
// 4
// Edges
// [[1, 0], [2, 0], [3, 0]]
// Your Output
// True
// Expected Output
// True

// V
// 6
// Edges
// [[2,3],[3,1],[4,0],[4,1],[5,0],[5,2]]
// Your Output
// True
// Expected Output
// True