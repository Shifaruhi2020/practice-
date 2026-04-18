
//  solution vid : https://www.youtube.com/watch?v=uzVUw90ZFIg&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=13
class Solution {


    public boolean dfs(int x, List<List<Integer>> adj, int[] vis, int[] dfs_vis){

        vis[x] = 1;
        dfs_vis[x] = 1;

        for(int it : adj.get(x)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, dfs_vis) == true){
                    return true;
                }
        }
            else if(dfs_vis[it] == 1){
                return true;
            }
        }
        dfs_vis[x] = 0;
        return false;

    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        
        int[] vis = new int[N];
        int[] dfs_vis = new int[N];

        for(int i = 0 ; i < N; i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, dfs_vis) == true) return true;
            }
        }
        return false;
    }
    
}

// V
// 4
// Edges
// [[0, 1], [0, 2], [1, 2], [3, 0], [3, 2]]

// Your Output
// False

// Expected Output
// False

// V
// 6
// Edges
// [[0, 1], [1, 2], [1, 5], [2, 3], [3, 4], [4, 1]]

// Your Output
// True

// Expected Output
// True
