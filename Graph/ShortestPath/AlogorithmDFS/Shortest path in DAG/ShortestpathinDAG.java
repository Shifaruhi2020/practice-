// solution link : https://www.youtube.com/watch?v=ZUFQfFaU-8U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=28
class Pair{
    int child;
    int dist;

    Pair(int child, int dist){
        this.child = child;
        this.dist = dist;
    }
}

class Solution {

  public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack,int[] vis){

    vis[node] = 1;

    for (Pair p : adj.get(node)) {
            if (vis[p.child] == 0) {
                topoSort(p.child, adj, stack, vis);
            }
        }
        stack.push(node); // correct position
    }


  public int[] shortestPath(int N, int M, int[][] edges) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for(int i = 0; i < N; i++){
        adj.add(new ArrayList<>());
    }

    for(int i = 0; i < M; i++){
        int u = edges[i][0];
        int neighbour = edges[i][1];
        int wt = edges[i][2];

        adj.get(u).add(new Pair(neighbour, wt));
    }

    Stack<Integer> st = new Stack<>();
    int[] vis = new int[N];

    for(int i = 0; i < N; i++){
        if(vis[i] == 0){
            topoSort(i, adj, st, vis);
        }
    }

    int[] distance = new int[N];
    for(int i = 0; i < N; i++){
        distance[i] = (int)1e9;
    }

    distance[0] = 0;

    while(!st.isEmpty()){
        int src = st.pop();

        if(distance[src] != (int)1e9){
            for(Pair p : adj.get(src)){
            if(distance[src] + p.dist < distance[p.child]){
                distance[p.child] = distance[src] + p.dist;
                }
            }
        }
    }

    for (int i = 0; i < N; i++) {
        if (distance[i] == (int)1e9) {
                distance[i] = -1;
        }
    }
    return distance;
  }
}