// solution link : https://www.youtube.com/watch?v=C4gxoTaI71U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=29
class Solution {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adj = new ArrayList<>();
        int src = 0;

        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
           adj.get(edges[i][0]).add(edges[i][1]);
           adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dis = new int[N];

        for(int i = 0; i < N; i++) dis[i] = (int) 1e9;

        dis[src] = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(src);

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int neighbour : adj.get(node)){
                if(dis[node] + 1 < dis[neighbour]){
                    dis[neighbour] = 1 + dis[node];
                    q.add(neighbour);
                }
            }
        }

        for(int item = 0; item < N; item++){
            if(dis[item] == (int)1e9 ){
                    dis[item] = -1;
            }
        }
        return dis;
    }
}
