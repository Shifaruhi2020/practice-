// solution link : https://www.youtube.com/watch?v=U5Mw4eyUmw4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=37
// also refer chatGPT for solution
class Pair{
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0){
            return -1;
        } 

        if(n == 1) {
            return 1;
        } 

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        int[][] dist = new int[n][n];

        for(int i =0; i < grid.length; i++){
            Arrays.fill(dist[i], (int) 1e9);
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, 1));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int row = curr.row;
            int col = curr.col;
            int distance = curr.dist;

            if(row == n -1 && col == n -1){
                return distance;
            }

            for(int i = 0; i < 8; i++){
                int newR = dr[i] + row;
                int newC = dc[i] + col;

                if(newR >= 0 && newR < n && newC >= 0 && newC < n 
                && grid[newR][newC] == 0 &&
                distance + 1 < dist[newR][newC]){
                    dist[newR][newC] = distance + 1;
                    q.offer(new Pair(newR, newC, distance + 1));
                }
            }
        }
        return -1;
    }
}