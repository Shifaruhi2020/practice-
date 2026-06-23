// SOLUTION LINK :  https://www.youtube.com/watch?v=9XybHVqTHcQ
class Pair{

    // destination node
    // flight cost

    int node;
    int cost;

    Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

class Tuple {
    int stops;
    int node;
    int cost;

    Tuple(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            adj.get(from).add(new Pair(to, cost));
        }

        // 0 -> (1,5) (3,2)

        // 1 -> (2,5) (4,1)

        // 3 -> (1,2)

        // 4 -> (2,1)

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(0, src, 0));

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while(!q.isEmpty()){

            Tuple cur = q.poll();

            int stops = cur.stops;
            int node = cur.node;
            int cost = cur.cost;

            if(stops > k) continue;

            for(Pair neighbour : adj.get(node)){
                int adjNode = neighbour.node;
                int adjPrice = neighbour.cost;

                int newCost = cost + adjPrice;

                if(newCost < dist[adjNode]){
                    dist[adjNode] = newCost;
                    q.offer(new Tuple(stops + 1, adjNode, newCost));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;

        return dist[dst];  
    }
}