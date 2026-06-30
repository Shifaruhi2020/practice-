// vid Link : https://www.youtube.com/watch?v=mJcZjjKzeqk
class Tuple {
    int wt;
    int node;
    int parent;

    Tuple(int wt, int node, int parent){
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
}

class Pair{
    int parent;
    int node;

    Pair(int parent, int node){
        this.parent = parent;
        this.node = node;
    }
}

class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        int vis[] = new int[V];

        // Arrays.fill(vis, 0);

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);

        int sum = 0;
        
        ArrayList<Pair> mst = new ArrayList<>();

        pq.offer(new Tuple(0, 0, -1));

        while(!pq.isEmpty()){
            Tuple cur = pq.poll();

            int weight = cur.wt;
            int nd = cur.node;
            int prnt = cur.parent;

            if(vis[nd] == 1){
                continue;
            }

            vis[nd] = 1;

            sum += weight;

            if(prnt != -1) mst.add(new Pair(prnt, nd));

            for(List<Integer> neighborPair : adj.get(nd)){
                int neighbor = neighborPair.get(0);
                int neighbor_weight = neighborPair.get(1);

                if(vis[neighbor] != 1){
                    pq.offer(new Tuple(neighbor_weight, neighbor, nd));
                }
   
            }
        }
        return sum; 
    }
}


