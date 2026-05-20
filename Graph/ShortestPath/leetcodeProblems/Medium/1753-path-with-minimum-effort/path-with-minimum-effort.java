// solution link : https://www.youtube.com/watch?v=0ytpZyiZFhA
class Tuple{
    int row;
    int col;
    int distance;

    Tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y)-> x.distance - y.distance);

        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            Tuple cur = pq.peek();
            int r = cur.row;
            int c = cur.col;
            int dist_cur = cur.distance;

            pq.remove();

            for(int i = 0; i < 4; i++){
                int new_r = r + dr[i];
                int new_c = c + dc[i];

                if(r == m - 1 && c == n - 1) return dist_cur;
            
                if( new_r >= 0  && new_r < m && new_c >= 0 && new_c < n){
                    int new_Effort = Math.max(Math.abs(heights[r][c] - heights[new_r][new_c]), dist_cur);

                    if(new_Effort < dist[new_r][new_c]){
                        dist[new_r][new_c] = new_Effort;
                        pq.add(new Tuple(new_Effort, new_r, new_c));
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}