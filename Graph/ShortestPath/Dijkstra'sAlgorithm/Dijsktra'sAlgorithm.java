// link solution : https://www.youtube.com/watch?v=V6H1qAeB-l4&t=8s

class Pair{
    int node;
    int distance;

    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

class Solution
{
    public  int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S)
    {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);

            // Add neighbor as [v, w]
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            temp.add(w);

            adj.get(u).add(temp);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);

        int[] dist = new int[V];

        Arrays.fill(dist, (int)1e9);
        dist[S] = 0;

        pq.add(new Pair(0, S));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int pq_dis = current.distance;
            int pq_node = current.node;

            for(int i = 0; i < adj.get(pq_node).size(); i++){
                int edge_weight_adj = adj.get(pq_node).get(i).get(1);
                int node_edges = adj.get(pq_node).get(i).get(0);

                int compareable_dist = pq_dis + edge_weight_adj;

                if(compareable_dist < dist[node_edges]){
                    dist[node_edges] = compareable_dist;
                    pq.add(new Pair(dist[node_edges], node_edges));
                }
            }
        }
        return dist;
    }
}
