// vid link : https://www.youtube.com/watch?v=BPlrALf1LDU
// code studied from chatGPT

class Pair{
    int node;
    int parent;
    Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
} 

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] vis = new int[V];

        for(int i =0; i < V ; i++){

            if(vis[i] == 0){
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, -1));

                vis[i] = 1;

                while(!q.isEmpty()){
                    Pair cur = q.remove();

                    int node = cur.node;
                    int parent = cur.parent;

                    for(int neighbour : adj[node]){
                        if(vis[neighbour] == 0){
                            q.add(new Pair(neighbour, node));
                            vis[neighbour] = 1;
                        }
                        else if(neighbour != parent){
                            return true;
                        }
                    }
                } 
            }
        }

    return false;

    }
}
